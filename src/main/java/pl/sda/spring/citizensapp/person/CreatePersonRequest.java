package pl.sda.spring.citizensapp.person;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePersonRequest {

    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;
}
