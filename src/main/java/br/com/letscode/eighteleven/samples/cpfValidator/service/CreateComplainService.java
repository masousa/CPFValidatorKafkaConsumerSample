package br.com.letscode.eighteleven.samples.cpfValidator.service;

import br.com.letscode.eighteleven.samples.cpfValidator.domain.ReclamacoesCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.RequestComplainBody;
import br.com.letscode.eighteleven.samples.cpfValidator.repository.ReclamacoesCPFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateComplainService {

    private final ReclamacoesCPFRepository reclamacoesCPFRepository;

    public void execute(RequestComplainBody requestComplainBody){

        ReclamacoesCPF reclamacoesCPF = new ReclamacoesCPF();
        reclamacoesCPF.setCpfReclamado(requestComplainBody.getCpfReclamado());
        reclamacoesCPF.setCnpjReclamante(requestComplainBody.getCnpjReclamante());
        reclamacoesCPF.setNomeReclamante(requestComplainBody.getNomeReclamante());
        reclamacoesCPFRepository.save(reclamacoesCPF);
    }
}
