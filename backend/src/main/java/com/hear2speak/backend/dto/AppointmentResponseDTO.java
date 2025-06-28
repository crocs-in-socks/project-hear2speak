package com.hear2speak.backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// For server -> client
public record AppointmentResponseDTO(
    Long id,
    String fullName,
    String emailAddress,
    String phoneNumber,
    LocalDate appointmentDate,
    LocalTime appointmentTime,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
