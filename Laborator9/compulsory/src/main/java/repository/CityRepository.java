package repository;

import java.util.List;
import javax.persistence.EntityManager;
import entities.City;
import entities.Country;
import tools.ManagerEntities;

public class CityRepository {

    private EntityManager em;

    public CityRepository() {
        em = ManagerEntities.getInstance();
    }

    public List<City> findByCountry(Country country) {
        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public List<City> findByName(String name) {
        return em.createNamedQuery("City.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public City findById(Integer id) {
        return (City) em.createNamedQuery("City.findById")
                .setParameter("id", id).getSingleResult();
    }

    public void create(City city) {
        em.persist(city);
    }
}
