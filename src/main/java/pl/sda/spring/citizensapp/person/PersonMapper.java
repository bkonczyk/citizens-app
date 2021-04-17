package pl.sda.spring.citizensapp.person;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person csvToPerson(PersonCsvEntry personCsvEntry);
}
