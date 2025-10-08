package br.com.fiap.msnotification.datasource;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.interfaces.DataSource;
import br.com.fiap.msnotification.exception.CreateEmailTemplateException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class EmailDataSourceImpl implements DataSource {

    private final JavaMailSender mailSender;

    public EmailDataSourceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailDomain email, String template) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@gmail.com");
            helper.setSubject(email.getTitle());
            helper.setTo(email.getClientEmail());
            helper.setText(template, true);
            mailSender.send(message);
        } catch (Exception e) {
            log.error("Erro ao se cgit onectar com e-mail: " + e.getMessage());
        }
    }

    @Override
    public String changeTemplate() throws IOException {
        log.info("Buildando template de email a ser enviado");
        ClassPathResource resource = new ClassPathResource("email-template.html");
        if (!resource.exists()){
            log.error("Template de email não encontrado ou corrompido");
            throw new CreateEmailTemplateException("Template de email não encontrado");
        }
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
