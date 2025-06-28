package com.hear2speak.backend.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentCreateDTO(
        @NotBlank(message = "Full name is required")
        String fullName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String emailAddress,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "\\d{10}", message = "Phone number must be valid")
        String phoneNumber,

        @NotNull(message = "Appointment date is required")
        LocalDate appointmentDate,

        @NotNull(message = "Appointment time is required")
        LocalTime appointmentTime,

        @Size(max = 1000, message = "Description can be up to 1000 characters")
        String description
) {}
