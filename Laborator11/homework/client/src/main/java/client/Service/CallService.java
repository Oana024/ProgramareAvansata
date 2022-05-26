package client.Service;

import client.entities.Person;
import client.entities.Relationship;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class CallService {

    RestTemplate restTemplate;

    public CallService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/call/person")
    public Person[] getPersons() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person", HttpMethod.GET, entity, Person[].class).getBody();
    }

    @RequestMapping("/call/person/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/" + id, HttpMethod.GET, entity, Person.class).getBody();
    }

    @RequestMapping(value = "/call/person/count")
    public Integer countPersons() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/count", HttpMethod.GET, entity, Integer.class).getBody();
    }

    @RequestMapping(value = "/call/person/create")
    public Integer createPerson(@RequestParam String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/create?name=" + name, HttpMethod.POST, entity, Integer.class).getBody();
    }

    @RequestMapping(value = "/call/person/update/{id}")
    public String updatePerson(@PathVariable int id, @RequestParam String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/" + id + "?name=" + name, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/call/person/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    @RequestMapping(value = "/call/person/popularity/{k}")
    public Person[] getMostPopularKPersons(@PathVariable int k) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/person/popularity/" + k, HttpMethod.GET, entity, Person[].class).getBody();
    }


    @RequestMapping(value = "/call/relationship")
    public Relationship[] getRelationships() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/relationship", HttpMethod.GET, entity, Relationship[].class).getBody();
    }

    @RequestMapping("/call/relationship/{id}")
    public Relationship getRelationship(@PathVariable("id") int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/relationship/" + id, HttpMethod.GET, entity, Relationship.class).getBody();
    }

    @RequestMapping(value = "/call/relationship/count")
    public Integer countRelationship() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/relationship/count", HttpMethod.GET, entity, Integer.class).getBody();
    }

    @RequestMapping(value = "/call/relationship/delete/{id}")
    public String deleteRelationship(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8010/relationship/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
