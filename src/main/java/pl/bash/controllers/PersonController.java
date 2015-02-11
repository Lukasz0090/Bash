package pl.bash.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bash.dao.PersonDao;
import pl.bash.entity.Person;

@ManagedBean
@Component
public class PersonController {

	@Autowired
	private PersonDao personDao; 
	
	private List<Person> persons = new ArrayList<>();
	private String napis = "napis kontrolny";
	
	@PostConstruct
	private void initPersons() {
		persons = personDao.findAll();
	}

	public List<Person> getPersons() {
		persons = personDao.findAll();
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String getNapis() {
		return napis;
	}

	public void setNapis(String napis) {
		this.napis = napis;
	}
}