package com.hear2speak.backend.mapper;

import com.hear2speak.backend.domain.Appointment;
import com.hear2speak.backend.dto.AppointmentCreateDTO;
import com.hear2speak.backend.dto.AppointmentPartialUpdateDTO;
import com.hear2speak.backend.dto.AppointmentResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toEntity(AppointmentCreateDTO dto);
    AppointmentResponseDTO toDTO(Appointment entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Appointment entity, AppointmentPartialUpdateDTO dto);

}
