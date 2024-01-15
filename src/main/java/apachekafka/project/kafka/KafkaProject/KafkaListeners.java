package apachekafka.project.kafka.KafkaProject;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "Dmessage", groupId = "Dmessage1")
    void Listener (String data) {

        System.out.println("Listener recieved - "  + data );
    }
}
