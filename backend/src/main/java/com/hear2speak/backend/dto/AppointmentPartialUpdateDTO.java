package com.hear2speak.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public record AppointmentPartialUpdateDTO(
        String fullName,

        @Email(message = "Email must be valid")
        String emailAddress,

        @Pattern(regexp = "\\d{10}", message = "Phone number must be valid")
        String phoneNumber,

        LocalDate appointmentDate,

        LocalTime appointmentTime,

        @Size(max = 1000, message = "Description can be up to 1000 characters")
        String description
) {}
