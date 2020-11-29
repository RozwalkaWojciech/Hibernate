package service;

import dao.PersonDao;
import model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    public Person savePerson(Person person) {
        return personDao.savePerson(person);
    }
}
