package org.bedu.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class InterviewerControllerIntegrationTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("GET /interviewers should return an empty list of interviewers")
  void emptyListTest() throws Exception {
    MvcResult result = this.mockMvc
      .perform(get("/interviewers"))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();

    String content = result.getResponse().getContentAsString();

    assertEquals("[]", content);
  }

  @Test
  @DisplayName("POST /interviewers should return error 400 if request body is invalid")
  void saveBadRequestTest() throws Exception {
    MvcResult result = this.mockMvc
      .perform(post("/interviewers").contentType("application/json").content("{}"))
      .andDo(print())
      .andExpect(status().isBadRequest())
      .andReturn();

    String content = result.getResponse().getContentAsString();

    assertEquals("{\"code\":\"ERR_VALID\",\"message\":\"Hubo un error al validar los datos de entrada\",\"details\":[\"El correo electronico es obligatorio\",\"El nombre es obligatorio\"]}", content);
  }
}
