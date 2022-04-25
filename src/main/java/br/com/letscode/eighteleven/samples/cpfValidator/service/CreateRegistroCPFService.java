package br.com.letscode.eighteleven.samples.cpfValidator.service;

import br.com.letscode.eighteleven.samples.cpfValidator.domain.RegistroCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddRequestCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddResponseCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.repository.RegistroCPFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateRegistroCPFService {

    private final RegistroCPFRepository registroCPFRepository;


    @CacheEvict(cacheNames = "statuscpf", allEntries = true)
    public AddResponseCPF execute(AddRequestCPF addRequestCPF){
        Optional<RegistroCPF> registroExistente = registroCPFRepository.findFirstByCpf(addRequestCPF.getCPF());
        String uuid = UUID.randomUUID().toString();
        if(registroExistente.isEmpty()) {
            RegistroCPF registroCPF = new RegistroCPF();
            registroCPF.setCpf(addRequestCPF.getCPF());
            registroCPF.setNome(addRequestCPF.getNome());
            registroCPF.setUuid(uuid);
            registroCPFRepository.save(registroCPF);
        }else{
            uuid = registroExistente.get().getUuid();
        }

        AddResponseCPF addResponseCPF = AddResponseCPF.fromRequest(addRequestCPF);
        addResponseCPF.setIdentificador(uuid);


        return addResponseCPF;
    }


}
