package pl.sda.spring.citizensapp.person;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CreatePersonRequest {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "lastName cannot be empty")
    private String lastName;

    @Size(min = 1, max = 1, message = "Sex should be either M or F")
    private String sex;

    @Past(message = "birthDate has to be in the past")
    private LocalDate birthDate;
}
