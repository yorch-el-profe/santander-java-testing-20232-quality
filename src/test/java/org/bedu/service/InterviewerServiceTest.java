package org.bedu.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InterviewerServiceTest {
  
  @Autowired
  private InterviewerService service;

  @Test
  @DisplayName("Service should be injected")
  public void smokeTest() {
    assertNull(service);
  }
}
