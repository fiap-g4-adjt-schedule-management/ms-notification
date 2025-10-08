package br.com.fiap.msnotification.mapper;

import br.com.fiap.msnotification.core.domain.EmailDomain;
import br.com.fiap.msnotification.core.domain.ScheduleType;
import br.com.fiap.msnotification.dto.NotificationDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailMapper {

    public static EmailDomain toDomain(NotificationDTO notificationDTO) {
        return EmailDomain.create(
                notificationDTO.title(),
                notificationDTO.pacientName(),
                notificationDTO.doctorName(),
                notificationDTO.date(),
                ScheduleType.valueOf(notificationDTO.type()),
                notificationDTO.clientEmail(),
                notificationDTO.clientPhone()
        );
    }
}
