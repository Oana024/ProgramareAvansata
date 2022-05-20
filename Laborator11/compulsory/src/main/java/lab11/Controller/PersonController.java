package lab11.Controller;

import lab11.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final List<Person> personList = new ArrayList<>();

    @Autowired
    public PersonController() {
        personList.add(new Person(1, "Person1"));
        personList.add(new Person(2, "Person2"));
        personList.add(new Person(3, "Person3"));
    }

    @GetMapping
    public List<Person> getPersonList() {
        return personList;
    }

    @GetMapping("/count")
    public int countPersons() {
        return personList.size();
    }

    @PostMapping("/create")
    public int createPerson(@RequestParam String name) {
        int id = 1 + personList.size();
        personList.add(new Person(id, name));
        return id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id, @RequestParam String name) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND);
        }
        person.setName(name);
        return new ResponseEntity<>(
                "Person updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        personList.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }


    private Person findById(int id) {
        return (Person) personList.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

}
