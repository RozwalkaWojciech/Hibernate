package dao;

import model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }

    public Person edit(Integer id, Person person) {
        Person toEdit = entityManager.find(Person.class, id);
        if (toEdit != null) {
            toEdit.setBirthdate(person.getBirthdate());
            toEdit.setLastName(person.getLastName());
            toEdit.setName(person.getName());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Person toRemove = entityManager.find(Person.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }
}
