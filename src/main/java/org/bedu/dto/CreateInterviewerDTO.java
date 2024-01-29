package org.bedu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateInterviewerDTO {
  @NotBlank(message = "El nombre es obligatorio")
  private String name;

  @NotBlank(message = "El correo electronico es obligatorio")
  @Email
  private String email;
}
