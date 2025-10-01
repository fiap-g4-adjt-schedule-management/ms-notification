package br.com.fiap.msnotification.core.interfaces;

import br.com.fiap.msnotification.core.domain.EmailDomain;

import java.io.IOException;

public interface DataSource {

    String changeTemplate() throws IOException;
    void sendEmail(EmailDomain emailDomain, String message);
}
