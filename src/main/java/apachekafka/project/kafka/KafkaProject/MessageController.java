package apachekafka.project.kafka.KafkaProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    public void publish1(@RequestBody String message) throws JSONException {

        JSONObject jsonObject = new JSONObject(message);
 /*       MessageRequest msg = new MessageRequest();
        msg.setMessage((String) message);*/
        String getmsg = jsonObject.getString("message");
        System.out.println("payload from API- " + getmsg);
        kafkaTemplate.send("Dmessage", getmsg);
    }

    @PostMapping("/send")
    public void publish(@RequestBody String messageRequest){
        kafkaTemplate.send("Dmessage", messageRequest);
    }
}
