package pl.sda.spring.citizensapp.person;

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
class PersonReader {

    @PostConstruct
    List<PersonCsvEntry> process() {
        File personFile = new File(getClass().getClassLoader().getResource("person.csv").getFile());
        return this.readFromFile(personFile);
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
