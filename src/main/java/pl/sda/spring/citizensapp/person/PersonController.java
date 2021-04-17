package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@RequestBody CreatePersonRequest request) {
        service.addPerson(request);
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
