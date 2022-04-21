package br.com.letscode.eighteleven.samples.cpfValidator.controllers;

import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddRequestCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddResponseCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.RequestComplainBody;
import br.com.letscode.eighteleven.samples.cpfValidator.payloads.StatusCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.service.CreateComplainService;
import br.com.letscode.eighteleven.samples.cpfValidator.service.CreateRegistroCPFService;
import br.com.letscode.eighteleven.samples.cpfValidator.service.GetCPFStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpf")
@RequiredArgsConstructor
public class CPFController {


    private final CreateRegistroCPFService createRegistroCPFService;
    private final CreateComplainService createComplainService;

    private final GetCPFStatusService getCPFStatusService;
    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AddResponseCPF addCpf(@RequestBody AddRequestCPF addRequestCPF){
        return createRegistroCPFService.execute(addRequestCPF);
    }

    @PostMapping("complain")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void makeComplain(@RequestBody RequestComplainBody requestComplainBody){
        createComplainService.execute(requestComplainBody);
    }

    @GetMapping("status/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    public StatusCPF getStatusCPF(@PathVariable(name = "cpf") String cpf){
        return getCPFStatusService.execute(cpf);
    }
}
