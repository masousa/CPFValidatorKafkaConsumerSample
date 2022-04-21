package br.com.letscode.eighteleven.samples.cpfValidator.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reclamacao")
@Data
public class ReclamacoesCPF {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String cpfReclamado;
    private String cnpjReclamante;
    private String nomeReclamante;
    private LocalDate dataReclamacao = LocalDate.now();

}
