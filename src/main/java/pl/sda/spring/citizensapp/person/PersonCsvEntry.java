package pl.sda.spring.citizensapp.person;

import lombok.Getter;
import pl.sda.spring.citizensapp.csv.CsvLine;

import java.time.LocalDate;

@Getter
class PersonCsvEntry {
//    private Long id;
    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;


    public PersonCsvEntry(CsvLine line) {
//        id = Long.parseLong(line.getElementAt(0));
        name = line.getElementAt(1);
        lastName = line.getElementAt(2);
        sex = line.getElementAt(3);
        birthDate = LocalDate.parse(line.getElementAt(4));
    }
}
