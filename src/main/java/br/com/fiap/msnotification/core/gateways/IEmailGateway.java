package br.com.fiap.msnotification.core.gateways;

import br.com.fiap.msnotification.core.domain.EmailDomain;

public interface IEmailGateway {

    String createTemplate();
    void sendEmail(EmailDomain emailDomain, String message);
}
