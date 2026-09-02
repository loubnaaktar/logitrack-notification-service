package org.example.logitracknotificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitracknotificationservice.dto.NotificationDTO;
import org.example.logitracknotificationservice.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService service;

    @GetMapping()
    public ResponseEntity<List<NotificationDTO>> getAllNotifications(){
        return ResponseEntity.ok(service.getAllNotifications());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsByOrederId(@PathVariable Long orderId){
        return ResponseEntity.ok(service.getNotificationsByOrderId(orderId));
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> creerNotification(@RequestBody NotificationDTO notificationDTO){
        NotificationDTO created = service.creerNotification(notificationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
     @PutMapping("/{id}/read")
    public ResponseEntity<NotificationDTO> markedRead(@PathVariable Long id){
        return ResponseEntity.ok(service.markRead(id));
     }
}
