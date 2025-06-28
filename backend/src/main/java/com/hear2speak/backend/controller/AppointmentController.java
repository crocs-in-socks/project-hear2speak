package com.hear2speak.backend.controller;

import com.hear2speak.backend.domain.Appointment;
import com.hear2speak.backend.dto.AppointmentCreateDTO;
import com.hear2speak.backend.dto.AppointmentPartialUpdateDTO;
import com.hear2speak.backend.dto.AppointmentResponseDTO;
import com.hear2speak.backend.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAll(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<AppointmentResponseDTO>> getPaged(@PageableDefault(size = 20, sort = "appointmentDate", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(appointmentService.getPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody @Valid AppointmentCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable Long id, @RequestBody AppointmentPartialUpdateDTO dto) {
        return ResponseEntity.ok(appointmentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
