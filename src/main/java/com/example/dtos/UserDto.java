package com.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //genera getters y setters
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @JsonProperty("username") //nombre de la propiedad
    private String userName;

    @Email //virifica que sea un email
    private String email;

}
