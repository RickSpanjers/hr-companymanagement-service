package nl.hrmanagement.companymanagement.rabbitmq;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;

import java.util.UUID;

@Service
public class TaskSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("archiveCompanyUsers")
    private Queue queueArchiveCompanyUsers;

    private Gson gson = new Gson();

    public TaskSender(){

    }

    public void send(UUID companyId) {
        template.convertAndSend(queueArchiveCompanyUsers.getName(), gson.toJson(companyId));
    }

}