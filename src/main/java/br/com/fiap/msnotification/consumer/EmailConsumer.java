package br.com.fiap.msnotification.consumer;

import br.com.fiap.msnotification.configuration.RabbitConfiguration;
import br.com.fiap.msnotification.core.controller.EmailController;
import br.com.fiap.msnotification.dto.NotificationDTO;
import br.com.fiap.msnotification.mapper.EmailMapper;
import br.com.fiap.msnotification.datasource.EmailDataSourceImpl;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final Logger log = LoggerFactory.getLogger(EmailConsumer.class);
    private EmailDataSourceImpl emailDataSourceImpl;

    public EmailConsumer(EmailDataSourceImpl emailDataSourceImpl) {
        this.emailDataSourceImpl = emailDataSourceImpl;
    }

    @RabbitListener(queues = RabbitConfiguration.NOTIFICATION_QUEUE, containerFactory = "manualAckListenerContainerFactory")
    public void listenEmailQueue(@Payload NotificationDTO notificationDTO, Message message, Channel channel) {
        try {
            EmailController emailController = EmailController.create(emailDataSourceImpl);
            emailController.sendEmail(EmailMapper.toDomain(notificationDTO));
            log.info("Receiving email notification: {}", notificationDTO);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("Error while receiving email notification: " + e.getMessage(), e);
        }
    }
}
