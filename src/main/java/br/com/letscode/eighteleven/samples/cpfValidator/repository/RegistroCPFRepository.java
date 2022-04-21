package br.com.letscode.eighteleven.samples.cpfValidator.repository;

import br.com.letscode.eighteleven.samples.cpfValidator.domain.RegistroCPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroCPFRepository  extends JpaRepository<RegistroCPF, Long> {
    Optional<RegistroCPF> findFirstByCpf(String cpf);
}
