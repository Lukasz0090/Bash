package pl.bash.entity;

//import java.sql.Date;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.faces.event.ActionEvent;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.bash.dao.QuotationDao;


@Entity
@ManagedBean(name="saveData")
@ViewScoped
public class Quotation {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 500)
	private String content;
	private Long rate = 0L;
	private Date date;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public void saveQuotation(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		String testQoat = content;
		QuotationDao quotationDao = context.getBean(QuotationDao.class);
		Quotation quotation = new Quotation();
		quotation.setContent(testQoat);
		quotation.setDate(Calendar.getInstance().getTime());
		quotationDao.save(quotation);
		context.close();
		String test = "testttt";
		test = test + test;
	}
	
	public void addRate(int id){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		QuotationDao quotationDao = context.getBean(QuotationDao.class);
		Quotation currentQuotation = quotationDao.getById(id);
		
		currentQuotation.setRate(currentQuotation.getRate()+1);
		quotationDao.save(currentQuotation);
		context.close();
	}


}