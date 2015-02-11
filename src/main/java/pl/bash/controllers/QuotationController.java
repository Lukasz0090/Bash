package pl.bash.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;




import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.bash.dao.QuotationDao;
import pl.bash.entity.Quotation;

@ManagedBean
@Component

public class QuotationController {
	@Autowired
	private QuotationDao quotationDao; 
	
	private List<Quotation> quotations = new ArrayList<>();
	private List<Quotation> quotationsNegative = new ArrayList<>();
	//private String quotation;
	
	@PostConstruct
	private void initQuotations() {
		quotations = quotationDao.findPositive();
		quotationsNegative = quotationDao.findNegative();
	}

	public List<Quotation> getQuotations() {
		quotations = quotationDao.findPositive();
		return quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
		}

	public List<Quotation> getQuotationsNegative() {
		quotationsNegative = quotationDao.findNegative();
		return quotationsNegative;
	}

	public void setQuotationsNegative(List<Quotation> quotationsNegative) {
		this.quotationsNegative = quotationsNegative;
	}
	
//	public void saveQuotation(){
//		
//		String test = "test";
//		test = this.quotation;
//	}


}
