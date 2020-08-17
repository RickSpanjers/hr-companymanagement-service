package nl.hrmanagement.companymanagement.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean(name="archiveCompanyUsers")
    public Queue archiveCompanyUsers() {
        return new Queue("archiveCompanyUsers");
    }
}