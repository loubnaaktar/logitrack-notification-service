package org.example.logitracknotificationservice.repository;

import org.example.logitracknotificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByOrderId(Long orderId);
}
