package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@Valid @RequestBody CreatePersonRequest request) {
        service.addPerson(request);
    }

    @GetMapping("/page")
    public Page<PersonListView> getPage(@RequestParam Short page, @RequestParam Short size) {
        return service.getPage(page, size);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return service.getPerson(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable Long id, @RequestBody UpdatePersonRequest request) {
        service.updatePerson(id, request);
    }

    @GetMapping("/adults")
    public List<PersonListView> getAdults() {
        return service.getAdults();
    }

    @GetMapping("/search")
    public List<PersonListView> getByNameAndSex(@RequestParam String name, @RequestParam String sex) {
        return service.getByNameAndSex(name, sex);
    }
}
