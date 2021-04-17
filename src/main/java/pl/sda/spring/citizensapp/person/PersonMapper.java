package pl.sda.spring.citizensapp.person;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    Person csvToPerson(PersonCsvEntry personCsvEntry) {
        return new Person()
            .setName(personCsvEntry.getName())
            .setLastName(personCsvEntry.getLastName())
            .setBirthDate(personCsvEntry.getBirthDate())
            .setSex(personCsvEntry.getSex());
    }

    Person createRequestToPerson(CreatePersonRequest request) {
        return new Person()
            .setName(request.getName())
            .setLastName(request.getLastName())
            .setBirthDate(request.getBirthDate())
            .setSex(request.getSex());
    }

    PersonListView toPersonListView(Person person) {
        return PersonListView.of(person.getName(), person.getBirthDate());
    }
}
