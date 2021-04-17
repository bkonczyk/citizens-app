package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PersonListView> getAdults() {
        LocalDate adultBirthDate = LocalDate.now().minusYears(30L);

        return repository.findAdults(adultBirthDate).stream()
            .map(mapper::toPersonListView)
            .collect(Collectors.toList());
    }

    public List<PersonListView> getByName(String name) {
        return repository.findAllByName(name).stream()
            .map(mapper::toPersonListView)
            .collect(Collectors.toList());


//        return repository.findAll().stream()
//            .filter(person -> person.getName().equals(name))
//            .map(mapper::toPersonListView)
//            .collect(Collectors.toList());
    }

    public List<PersonListView> getByNameAndSex(String name, String sex) {
        return repository.findAllByNameAndSex(name, sex).stream()
            .map(mapper::toPersonListView)
            .collect(Collectors.toList());
    }
}
