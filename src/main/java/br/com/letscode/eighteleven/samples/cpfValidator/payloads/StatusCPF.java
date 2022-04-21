package br.com.letscode.eighteleven.samples.cpfValidator.payloads;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusCPF implements Serializable {
    private String nome;
    private CPFStatus cpfStatus;
}
