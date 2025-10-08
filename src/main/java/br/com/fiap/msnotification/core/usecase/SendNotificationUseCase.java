package br.com.fiap.msnotification.core.usecase;

import br.com.fiap.msnotification.consumer.EmailConsumer;
import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.gateways.IEmailGateway;
import br.com.fiap.msnotification.exception.SendingEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;

public class SendNotificationUseCase {

    private final IEmailGateway emailGateway;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final Logger log = LoggerFactory.getLogger(EmailConsumer.class);

    public SendNotificationUseCase(IEmailGateway emailGateway) {;
        this.emailGateway = emailGateway;
    }

    public void run(EmailDomain emailDomain) {
        log.info("Iniciando envio de email para: {}", emailDomain.getClientEmail());
       try {
           String template = emailGateway.createTemplate();
           String message = updateMessage(template, emailDomain);
           emailGateway.sendEmail(emailDomain,message);
       } catch (Exception e) {
           throw  new SendingEmailException("Erro ao enviar email: " + e.getMessage());
       }
    }

    private String updateMessage(String template, EmailDomain emailDomain) {
        template = template.replace("#{pacient}", emailDomain.getPacientName());
        template = template.replace("#{type}", emailDomain.getType().getDescription());
        template = template.replace("#{date}", dtf.format(emailDomain.getDate()));
        template = template.replace("#{doctor}", emailDomain.getDoctorName());
        return template;
    }
}
