package br.com.letscode.eighteleven.samples.cpfValidator.payloads;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Data
public class RequestComplainBody {
    @CPF(message = "CPF não foi informado")
    private String cpfReclamado;
    @CNPJ(message = "É preciso informar o denunciante")
    private String cnpjReclamante;
    @NotBlank(message = "Informe o nome do denunciante")
    private String nomeReclamante;
}
