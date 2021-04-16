package pl.sda.spring.citizensapp.person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class PersonReader {

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

        System.out.println("Converted " + personCsvEntries.size() + " in " + (stop - start) + " ms");
        return personCsvEntries;
    }
}
