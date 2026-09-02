package org.example.logitracknotificationservice.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.logitracknotificationservice.dto.NotificationDTO;
import org.example.logitracknotificationservice.mapper.NotificationMapper;
import org.example.logitracknotificationservice.model.Notification;
import org.example.logitracknotificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class NotificationService {
    private final NotificationRepository repo;
    private final NotificationMapper mapper;


    public List<NotificationDTO> getAllNotifications(){
        return mapper.toDtoList(repo.findAll());
    }

    public NotificationDTO getNotificationById(Long id){
        Notification notification = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable avec l'id : " + id));
        return mapper.toDto(notification);
    }

    public List<NotificationDTO> getNotificationsByOrderId(Long orderId){
        return mapper.toDtoList(repo.findByOrderId(orderId));
    }

    public NotificationDTO creerNotification(NotificationDTO dto){
        Notification notification = mapper.toEntity(dto);
        if(notification.getDateCreation() == null){
            notification.setDateCreation(LocalDateTime.now());
        }
        notification.setReadStatus(false);
        Notification saved = repo.save(notification);
        return mapper.toDto(saved);
    }

    public NotificationDTO markRead(Long id){
        Notification notification = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable avec l'id :" + id ));
        notification.setReadStatus(true);
        Notification updated = repo.save(notification);
        return mapper.toDto(updated);
    }
}