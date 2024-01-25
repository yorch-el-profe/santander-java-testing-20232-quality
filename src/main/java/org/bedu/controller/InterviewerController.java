package org.bedu.controller;

import java.util.List;

import org.bedu.dto.CreateInterviewerDTO;
import org.bedu.dto.InterviewerDTO;
import org.bedu.service.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("interviewers")
public class InterviewerController {
  
  @Autowired
  private InterviewerService service;

  @GetMapping
  public List<InterviewerDTO> findAll() {
    return service.findAll();
  }

  @PostMapping
  public InterviewerDTO save(@Valid @RequestBody CreateInterviewerDTO dto) {
    return service.save(dto);
  }
}
