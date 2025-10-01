package br.com.fiap.msnotification.core.gateways;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.interfaces.DataSource;

public class EmailGateway implements IEmailGateway {

    private final DataSource dataSource;

    public EmailGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String createTemplate() {
       try{
           return this.dataSource.changeTemplate();
       } catch (Exception e) {
           throw new RuntimeException("Erro ao criar template: " + e.getMessage());
       }
    }

    @Override
    public void sendEmail(EmailDomain emailDomain, String message){
        this.dataSource.sendEmail(emailDomain, message);
    }

}
