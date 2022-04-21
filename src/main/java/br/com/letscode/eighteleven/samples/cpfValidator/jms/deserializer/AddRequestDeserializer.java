package br.com.letscode.eighteleven.samples.cpfValidator.jms.deserializer;

import br.com.letscode.eighteleven.samples.cpfValidator.payloads.AddRequestCPF;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class AddRequestDeserializer implements Deserializer<AddRequestCPF> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public AddRequestCPF deserialize(String s, byte[] bytes) {
        try {
            if(Objects.nonNull(bytes)){

                    return mapper.readValue(new String(bytes, StandardCharsets.UTF_8),AddRequestCPF.class);

            }
        } catch (JsonProcessingException e) {
            log.error("json processing error on deserialize kafka object",e);

        }
        return null;
    }
}
