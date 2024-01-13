package apachekafka.project.kafka.KafkaProject;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Dmessage", groupId = "Dmessage")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
        // Add your message processing logic here
    }
}
