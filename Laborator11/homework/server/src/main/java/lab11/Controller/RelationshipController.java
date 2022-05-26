package lab11.Controller;

import lab11.Entity.Person;
import lab11.Entity.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    private static final List<Relationship> relationshipList = new ArrayList<>();

    @Autowired
    public RelationshipController() {
        relationshipList.add(new Relationship(1, new Person(1, "Person1"), new Person(2, "Person2")));
        relationshipList.add(new Relationship(2, new Person(3, "Person3"), new Person(4, "Person4")));
        relationshipList.add(new Relationship(3, new Person(1, "Person5"), new Person(3, "Person6")));
        relationshipList.add(new Relationship(4, new Person(3, "Person7"), new Person(5, "Person8")));

        Person p;
        for (Relationship relationship : relationshipList) {
            p = PersonController.findById(relationship.getPerson1().getId());
            p.addFriend();
            p = PersonController.findById(relationship.getPerson2().getId());
            p.addFriend();
        }
    }

    @GetMapping
    public List<Relationship> getRelationshipList() {
        return relationshipList;
    }

    @GetMapping("/count")
    public int countRelationships() {
        return relationshipList.size();
    }

    @GetMapping("/{id}")
    public Relationship getRelationShip(@PathVariable("id") int id) {
        return relationshipList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public int createRelationship(@RequestBody Relationship relationship) {
        int id = 1 + relationshipList.size();
        relationship.setId(id);
        relationshipList.add(relationship);
        Person p = PersonController.findById(relationship.getPerson1().getId());
        p.addFriend();
        p = PersonController.findById(relationship.getPerson2().getId());
        p.addFriend();
        return id;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteRelationship(@PathVariable int id) {
        Relationship relationship = findById(id);
        if (relationship == null) {
            return new ResponseEntity<>(
                    "Relationship not found", HttpStatus.GONE);
        }
        relationshipList.remove(relationship);

        Person p;
        p = PersonController.findById(relationship.getPerson1().getId());
        p.removeFriend();
        p = PersonController.findById(relationship.getPerson2().getId());
        p.removeFriend();

        return new ResponseEntity<>("Relationship removed", HttpStatus.OK);
    }

    private Relationship findById(int id) {
        return relationshipList.stream().filter(relationship -> relationship.getId().equals(id)).findFirst().orElse(null);
    }
}
