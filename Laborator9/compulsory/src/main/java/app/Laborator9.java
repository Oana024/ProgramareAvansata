package app;

import javax.persistence.EntityManager;
import entities.City;
import tools.ManagerEntities;
import repository.CityRepository;

public class Laborator9 {

    public static void main(String[] args) {
        EntityManager em = ManagerEntities.getInstance();
        em.getTransaction().begin();

        CityRepository cities = new CityRepository();
        City myCity = cities.findById(10);
        System.out.println("numele este: " + myCity.getName());
        ManagerEntities.reset();
    }
}
