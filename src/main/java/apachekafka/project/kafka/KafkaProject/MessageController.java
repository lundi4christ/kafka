package apachekafka.project.kafka.KafkaProject;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    @PostMapping("/send1")
    public void publish1(@RequestBody Object message){
        MessageRequest msg = new MessageRequest();
        msg.setMessage((String) message);
        String getmsg = msg.getMessage();
        System.out.println(msg.getMessage());
        kafkaTemplate.send("Dmessage", getmsg);
    }

    @PostMapping("/send")
    public void publish(@RequestBody String messageRequest){
        kafkaTemplate.send("Dmessage", messageRequest);
    }
}
