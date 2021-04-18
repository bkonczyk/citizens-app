package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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

    void updatePerson(Long id, UpdatePersonRequest request) {
        Person person = repository.findById(id).orElseThrow(NoSuchElementException::new);
        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setSex(request.getSex());
        repository.save(person);
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

    public Page<PersonListView> getPage(Short page, Short size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest).map(mapper::toPersonListView);
    }

    public Person getPerson(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
