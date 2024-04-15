package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDirectory {
    private List<PersonProfile> persons;

    public PersonDirectory() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(PersonProfile person) {
        persons.add(person);
    }

    public void removePerson(PersonProfile person) {
        persons.remove(person);
    }

    public PersonProfile findPersonById(String id) {
        return persons.stream()
                      .filter(person -> person.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }

    // find person by type (e.g. faculty or passenger)
    public <T extends PersonProfile> List<T> findPersonsByType(Class<T> type) {
        return persons.stream()
                      .filter(type::isInstance)
                      .map(type::cast)
                      .collect(Collectors.toList());
    }

    public List<PersonProfile> findPersonsByName(String name) {
        return persons.stream()
                      .filter(person -> person.getName().equalsIgnoreCase(name))
                      .collect(Collectors.toList());
    }
}
