package pl.bash.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import pl.bash.entity.Quotation;
@Repository
@Transactional
public class QuotationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Quotation save(Quotation quotation) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(quotation);
		return quotation;
	}
	public Quotation find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Quotation quotation = (Quotation) session.get(Quotation.class, id);
		return quotation;
	}
	
	@SuppressWarnings("unchecked")
	public List<Quotation> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Quotation> quotations = session.createQuery("SELECT q FROM Quotation q").list();
		return quotations;
	}
	
	@SuppressWarnings("unchecked")
	public List<Quotation> findPositive() {
		Session session = sessionFactory.getCurrentSession();
		List<Quotation> quotations = session.createQuery("SELECT q FROM Quotation q WHERE rate>=0").list();
		return quotations;
	}
	
	@SuppressWarnings("unchecked")
	public List<Quotation> findNegative() {
		Session session = sessionFactory.getCurrentSession();
		List<Quotation> quotations = session.createQuery("SELECT q FROM Quotation q WHERE rate<0").list();
		return quotations;
	}
	public Quotation getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Quotation quotation = (Quotation)session.createQuery("SELECT q FROM Quotation q WHERE id="+id);
		return quotation;
	}
	

}
