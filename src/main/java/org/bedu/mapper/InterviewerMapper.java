package org.bedu.mapper;

import java.util.List;

import org.bedu.dto.CreateInterviewerDTO;
import org.bedu.dto.InterviewerDTO;
import org.bedu.model.Interviewer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InterviewerMapper {

  List<InterviewerDTO> toDTO(List<Interviewer> model);
  
  InterviewerDTO toDTO(Interviewer model);

  @Mapping(target = "id", ignore = true)
  Interviewer toModel(CreateInterviewerDTO dto);
}
