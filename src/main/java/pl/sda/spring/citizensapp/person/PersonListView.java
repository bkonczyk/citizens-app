package pl.sda.spring.citizensapp.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@Accessors(chain = true)
@Getter
public class PersonListView {

    private String name;
    private LocalDate birthDate;
}
