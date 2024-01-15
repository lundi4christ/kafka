package apachekafka.project.kafka.KafkaProject;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic dmessageTopic(){
        return TopicBuilder.name("Dmessage").build();
    }
}
