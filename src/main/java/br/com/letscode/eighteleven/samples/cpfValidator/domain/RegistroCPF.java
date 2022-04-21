package br.com.letscode.eighteleven.samples.cpfValidator.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Registro")
@Data
public class RegistroCPF {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String uuid;

}
