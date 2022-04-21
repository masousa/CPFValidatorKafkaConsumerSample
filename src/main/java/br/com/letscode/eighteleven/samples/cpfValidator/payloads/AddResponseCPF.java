package br.com.letscode.eighteleven.samples.cpfValidator.payloads;

import lombok.Data;

@Data
public class AddResponseCPF extends AddRequestCPF{

    private String identificador;

    public static AddResponseCPF fromRequest(AddRequestCPF addRequestCPF) {
        var responseCPF = new AddResponseCPF();
        responseCPF.setCPF(addRequestCPF.getCPF());
        responseCPF.setNome(addRequestCPF.getNome());
        return responseCPF;
    }
}
