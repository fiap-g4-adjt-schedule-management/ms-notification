package br.com.fiap.msnotification.core.usecase;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.gateways.IEmailGateway;

import java.time.format.DateTimeFormatter;

public class SendNotificationUseCase {

    private final IEmailGateway emailGateway;

    public SendNotificationUseCase(IEmailGateway emailGateway) {;
        this.emailGateway = emailGateway;
    }

    public void run(EmailDomain emailDomain) {
       try {
           String template = emailGateway.createTemplate();
           String message = updateMessage(template, emailDomain);
           emailGateway.sendEmail(emailDomain,message);
       } catch (Exception e) {
           throw  new RuntimeException("Erro ao enviar email: " + e.getMessage());
       }
    }

    private String updateMessage(String template, EmailDomain emailDomain) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        template = template.replace("#{pacient}", emailDomain.getPacientName());
        template = template.replace("#{type}", emailDomain.getType());
        template = template.replace("#{date}", dtf.format(emailDomain.getDate()));
        template = template.replace("#{doctor}", emailDomain.getDoctorName());
        return template;
    }
}
