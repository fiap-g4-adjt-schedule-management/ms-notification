package br.com.fiap.msnotification.core.controller;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.gateways.EmailGateway;
import br.com.fiap.msnotification.core.gateways.IEmailGateway;
import br.com.fiap.msnotification.core.interfaces.DataSource;
import br.com.fiap.msnotification.core.usecase.SendNotificationUseCase;

public class EmailController {

    private final DataSource dataSource;

    private EmailController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static EmailController create(DataSource dataSource) {
        return new EmailController(dataSource);
    }

    public void sendEmail(EmailDomain email) {
        IEmailGateway emailGateway = new EmailGateway(this.dataSource);
        SendNotificationUseCase sendNotificationUseCase = new SendNotificationUseCase(emailGateway);

        sendNotificationUseCase.run(email);
        System.out.println("Email enviado com sucesso!");
    }
}
