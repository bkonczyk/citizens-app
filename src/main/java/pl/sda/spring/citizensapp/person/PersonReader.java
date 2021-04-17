package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.spring.citizensapp.csv.CsvFile;
import pl.sda.spring.citizensapp.csv.CsvLine;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
class PersonReader {

    private static final String PERSON_CSV_FILE = "person.csv";

    private final PersonService service;
    private final PersonMapper mapper;

    @PostConstruct
    void process() {
        File personFile = new File(getClass().getClassLoader().getResource(PERSON_CSV_FILE).getFile());
        List<PersonCsvEntry> csvEntries = this.readFromFile(personFile);
        csvEntries.stream()
            .map(mapper::csvToPerson)
            .forEach(service::addPerson);
    }

    private List<PersonCsvEntry> readFromFile(File fileName) {
        CsvFile csvLines = CsvFile.fromFile(fileName);
        List<PersonCsvEntry> personCsvEntries = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            personCsvEntries.add(new PersonCsvEntry(csvLine));
        }
        long stop = System.currentTimeMillis();
        log.info("Converted " + personCsvEntries.size() + " in " + (stop - start) + " ms");
        return personCsvEntries;
    }
}
