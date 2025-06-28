package com.hear2speak.backend.service;

import com.hear2speak.backend.domain.Appointment;
import com.hear2speak.backend.dto.AppointmentCreateDTO;
import com.hear2speak.backend.dto.AppointmentPartialUpdateDTO;
import com.hear2speak.backend.dto.AppointmentResponseDTO;
import com.hear2speak.backend.mapper.AppointmentMapper;
import com.hear2speak.backend.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentResponseDTO getById(Long id) {
        return appointmentRepository.findById(id)
                .map(appointmentMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
    }

    public List<AppointmentResponseDTO> getAll() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
    }

    public Page<AppointmentResponseDTO> getPaged(Pageable pageable) {
        return appointmentRepository.findAll(pageable)
                .map(appointmentMapper::toDTO);
    }

    public AppointmentResponseDTO create(AppointmentCreateDTO dto) {
        Appointment entity = appointmentMapper.toEntity(dto);
        return appointmentMapper.toDTO(entity);
    }

    public AppointmentResponseDTO update(Long id, AppointmentPartialUpdateDTO dto) {
        Appointment entity = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
        appointmentMapper.updateEntity(entity, dto);
        return appointmentMapper.toDTO(appointmentRepository.save(entity));
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

}
