package org.example.logitracknotificationservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.logitracknotificationservice.enums.NotificationType;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Setter
@Getter
public class NotificationDTO {
    private Long id;
    private String message;
    private NotificationType type;
    private LocalDateTime dateCreation;
    private boolean readStatus;
    private Long orderId;
}


