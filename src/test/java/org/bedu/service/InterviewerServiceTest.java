package org.bedu.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.bedu.dto.CreateInterviewerDTO;
import org.bedu.dto.InterviewerDTO;
import org.bedu.model.Interviewer;
import org.bedu.repository.InterviewerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.LinkedList;

@SpringBootTest
class InterviewerServiceTest {
  
  @MockBean
  private InterviewerRepository repository;

  @Autowired
  private InterviewerService service;

  @Test
  @DisplayName("Service should be injected")
  void smokeTest() {
    assertNotNull(service);
  }

  @Test
  @DisplayName("Service should retrieve all interviewers")
  void findAllTest() {
    List<Interviewer> data = new LinkedList<>();

    Interviewer interviewer = new Interviewer();

    interviewer.setId(1);
    interviewer.setName("Maria Gutierrez");
    interviewer.setEmail("maria.gutierrez@test.com");

    data.add(interviewer);

    when(repository.findAll()).thenReturn(data);

    List<InterviewerDTO> result = service.findAll();

    assertNotNull(result);
    assertTrue(result.size() > 0);
    assertEquals(interviewer.getId(), result.get(0).getId());
    assertEquals(interviewer.getName(), result.get(0).getName());
    assertEquals(interviewer.getEmail(), result.get(0).getEmail());
  }

  @Test
  @DisplayName("Service should save an interviewer")
  void saveTest() {
    CreateInterviewerDTO data = new CreateInterviewerDTO();

    data.setName("Maria Gutierrez");
    data.setEmail("maria.gutierrez@test.com");

    Interviewer interviewer = new Interviewer();

    interviewer.setId(1);
    interviewer.setName("Maria Gutierrez");
    interviewer.setEmail("maria.gutierrez@test.com");

    when(repository.save(any(Interviewer.class))).thenReturn(interviewer);

    InterviewerDTO result = service.save(data);

    assertNotNull(result);
    assertEquals(interviewer.getId(), result.getId());
    assertEquals(interviewer.getName(), result.getName());
    assertEquals(interviewer.getEmail(), result.getEmail());
  }
}
