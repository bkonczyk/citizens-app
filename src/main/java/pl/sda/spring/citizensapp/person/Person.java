package pl.sda.spring.citizensapp.person;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Accessors(chain = true)
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
