package br.com.letscode.eighteleven.samples.cpfValidator.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddRequestCPF {
    @NotBlank(message = "Nome a ser cadastrado é um item obrigatório")
    private String nome;
    @org.hibernate.validator.constraints.br.CPF(message = "Adicione um CPF válido")
    private String CPF;

}
