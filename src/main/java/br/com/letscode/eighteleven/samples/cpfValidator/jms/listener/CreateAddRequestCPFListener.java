package br.com.letscode.eighteleven.samples.cpfValidator.jms.listener;

import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddRequestCPF;
import br.com.letscode.eighteleven.samples.cpfValidator.service.CreateRegistroCPFService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAddRequestCPFListener {

    private final CreateRegistroCPFService createRegistroCPFService;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, AddRequestCPF> payload){
        log.info("Payload consumed {} ",payload.key());
        createRegistroCPFService.execute(payload.value());
    }
}
