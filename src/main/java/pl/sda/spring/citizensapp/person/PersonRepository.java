package pl.sda.spring.citizensapp.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByName(String name);

    List<Person> findAllByNameAndSex(String name, String sex);

    default List<Person> findAdults(LocalDate adultBirthDate) {
        return findAllByBirthDateBeforeOrderByBirthDateDesc(adultBirthDate);
    }
    List<Person> findAllByBirthDateBeforeOrderByBirthDateDesc(LocalDate adultBirthDate);
}
