package br.com.letscode.eighteleven.samples.cpfValidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNotFoundException extends RuntimeException{

     public RegistroNotFoundException(){
         super("Não foi possível encontrar o registro informado");
     }

}
