package pl.sda.spring.citizensapp.person;

import lombok.Data;

@Data
public class UpdatePersonRequest {

    private String name;
    private String lastName;
    private String sex;
}
