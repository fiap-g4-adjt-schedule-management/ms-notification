package br.com.fiap.msnotification.exception;

public class SendingEmailException extends RuntimeException {
    public SendingEmailException(String message) {
        super(message);
    }
}
