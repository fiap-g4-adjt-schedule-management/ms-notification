package br.com.fiap.msnotification.core.gateways;

import br.com.fiap.msnotification.core.domain.EmailDomain;

import java.io.IOException;

public interface IEmailGateway {

    String createTemplate() throws IOException;
    void sendEmail(EmailDomain emailDomain, String message);
}
