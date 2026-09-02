package org.example.logitracknotificationservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.logitracknotificationservice.enums.NotificationType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Setter
@Getter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private LocalDateTime dateCreation;

    private boolean readStatus;

    private Long orderId;

    public Notification() {
        this.dateCreation = LocalDateTime.now();
        this.readStatus = false;
    }

}
