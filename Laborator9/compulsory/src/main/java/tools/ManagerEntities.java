package tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerEntities {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        if (em == null) {
            createInstance();
        }
        return em;
    }

    private static void createInstance() {
        emf = Persistence.createEntityManagerFactory("EntitiesPU");
        em = emf.createEntityManager();
    }

    public static void reset() {
        em.close();
        emf.close();
        em = null;
        emf = null;
    }
}
