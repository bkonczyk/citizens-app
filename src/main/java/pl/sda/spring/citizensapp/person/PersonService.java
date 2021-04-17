package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    void addPerson(CreatePersonRequest request) {
        Person person = mapper.createRequestToPerson(request);
        repository.save(person);
    }

    void addPerson(Person person) {
        repository.save(person);
    }

    List<Person> getAll() {
        return repository.findAll();
    }

    void updatePerson() {

    }
}
