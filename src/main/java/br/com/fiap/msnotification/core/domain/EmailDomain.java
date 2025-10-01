package br.com.fiap.msnotification.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class EmailDomain {
    private String title;
    private String pacientName;
    private String doctorName;
    private LocalDateTime date;
    private String type;
    private String clientEmail;
    private String clientPhone;

    private EmailDomain(String title, String pacientName, String doctorName, LocalDateTime date, String type, String clientEmail, String clientPhone) {
        this.title = title;
        this.pacientName = pacientName;
        this.doctorName = doctorName;
        this.date = date;
        this.type = type;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
    }

    public static EmailDomain create(String title, String pacientName, String doctorName, LocalDateTime date, String type, String clientEmail, String clientPhone) {
        return new EmailDomain(title, pacientName, doctorName, date, type, clientEmail, clientPhone);
    }

}
