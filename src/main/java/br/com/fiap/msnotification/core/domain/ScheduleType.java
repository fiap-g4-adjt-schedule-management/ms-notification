package br.com.fiap.msnotification.core.domain;

public enum ScheduleType {

    SCHEDULED("Agendada"),
    CANCELED("Cancelada"),
    LOST("Perdida"),
    DONE("Concluída");

    private final String description;

    ScheduleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
