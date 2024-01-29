package org.bedu.service;

import java.util.List;

import org.bedu.dto.CreateInterviewerDTO;
import org.bedu.dto.InterviewerDTO;
import org.bedu.mapper.InterviewerMapper;
import org.bedu.model.Interviewer;
import org.bedu.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewerService {

  private InterviewerRepository repository;

  private InterviewerMapper mapper;

  @Autowired
  public InterviewerService(InterviewerMapper mapper, InterviewerRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }
  
  public InterviewerDTO save(CreateInterviewerDTO dto) {
    Interviewer model = mapper.toModel(dto);
    Interviewer result = repository.save(model);
    return mapper.toDTO(result);
  }

  public List<InterviewerDTO> findAll() {
    List<Interviewer> result = repository.findAll();
    return mapper.toDTO(result);
  }
}
