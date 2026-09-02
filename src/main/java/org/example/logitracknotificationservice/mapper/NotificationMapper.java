package org.example.logitracknotificationservice.mapper;

import org.example.logitracknotificationservice.dto.NotificationDTO;
import org.example.logitracknotificationservice.model.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
   NotificationDTO toDto(Notification entity);
   Notification toEntity(NotificationDTO dto);
   List<NotificationDTO> toDtoList(List<Notification> entityList);
}
