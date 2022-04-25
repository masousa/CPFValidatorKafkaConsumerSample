package br.com.letscode.eighteleven.samples.cpfValidator.service;

import br.com.letscode.eighteleven.samples.cpfValidator.domain.ReclamacoesCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.domain.RegistroCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.exception.RegistroNotFoundException;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.CPFStatus;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.StatusCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.repository.ReclamacoesCPFRepository;
import br.com.letscode.eighteleven.samples.cpfValidator.repository.RegistroCPFRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetCPFStatusService {
    private final RegistroCPFRepository registroCPFRepository;
    private final ReclamacoesCPFRepository reclamacoesCPFRepository;


    @Cacheable(cacheNames = "statuscpf", key = "#cpf")
    public StatusCPF execute(String cpf){
        log.info("Querying information for cpf {}", cpf);
        Optional<RegistroCPF> optionalRegistroCPF = registroCPFRepository.
                findFirstByCpf(cpf);
        StatusCPF statusCPF = new StatusCPF();
        statusCPF.setCpfStatus(CPFStatus.NAOCADASTRADO);

        if(optionalRegistroCPF.isPresent()) {

            statusCPF.setNome(optionalRegistroCPF.get().getNome());

            Long countStatus = reclamacoesCPFRepository.countByCpfReclamado(cpf);
            CPFStatus cpfStatus;
            if (countStatus <= 0) {
                cpfStatus = CPFStatus.DISPONIVEL;
            } else if (countStatus <= 2) {
                cpfStatus = CPFStatus.SUSPEITO;
            } else {
                cpfStatus = CPFStatus.INDISPONIVEL;
            }
            statusCPF.setCpfStatus(cpfStatus);
        }
        return statusCPF;

    }
}
