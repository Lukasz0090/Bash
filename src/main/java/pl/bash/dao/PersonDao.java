package pl.bash.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.bash.entity.Person;

@Repository
@Transactional
public class PersonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Person save(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(person);
		return person;
	}
	
	public Person find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, id);
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Person> persons = session.createQuery("SELECT p FROM Person p").list();
		return persons;
	}
}