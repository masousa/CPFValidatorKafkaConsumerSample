package br.com.letscode.eighteleven.samples.cpfValidator.repository;

import br.com.letscode.eighteleven.samples.cpfValidator.domain.ReclamacoesCPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacoesCPFRepository extends JpaRepository<ReclamacoesCPF, Long> {
    Long countByCpfReclamado(String cpf);
}
