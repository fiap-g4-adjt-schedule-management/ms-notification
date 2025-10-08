package br.com.fiap.msnotification.core.gateways;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.interfaces.DataSource;

import java.io.IOException;

public class EmailGateway implements IEmailGateway {

    private final DataSource dataSource;

    public EmailGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String createTemplate() throws IOException {
           return this.dataSource.changeTemplate();
    }

    @Override
    public void sendEmail(EmailDomain emailDomain, String message){
        this.dataSource.sendEmail(emailDomain, message);
    }

}
