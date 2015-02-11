package pl.bash;
import java.util.Date;
import java.util.List;

import javax.faces.bean.*;

import org.primefaces.*;
import org.hibernate.metamodel.relational.Database;
import org.springframework.context.support.ClassPathXmlApplicationContext;



//import pl.bash.dao.PersonDao;
import pl.bash.dao.QuotationDao;
import pl.bash.entity.Quotation;

@ManagedBean(name="main")
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		/*
		 * PersonDao personDao = context.getBean(PersonDao.class);
		 * 
		 * Person person = new Person(); person.setFirstName("Lkasz");
		 * person.setLastName("Guz");
		 * 
		 * personDao.save(person); System.out.println("Person::" + person);
		 * 
		 * Person person2 = personDao.find(person.getId());
		 * System.out.println("Person::" + person2);
		 * 
		 * List<Person> list = personDao.findAll(); for (Person p : list) {
		 * System.out.println("Person::" + p); }
		 * 
		 * context.close();
		 */


	}
		
	public void saveQuotation(String content){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		QuotationDao quotationDao = context.getBean(QuotationDao.class);
		Quotation quotation = new Quotation();
		quotation.setContent(content);
		quotationDao.save(quotation);
		context.close();
		
		}
	private String quotation;

	public String getQuotation() {
		return quotation;
	}

	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}

	
}