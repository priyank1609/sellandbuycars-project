package com.priyank.spring.sellandbuycar.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priyank.spring.sellandbuycar.dao.CarDetailsDao;
import com.priyank.spring.sellandbuycar.model.CarDetails;
import com.priyank.spring.sellandbuycar.model.UserLogin;

@Repository("carDetailsDao")
@Transactional
public class CarDetailsDaoImpl implements CarDetailsDao{
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOldCar(CarDetails carDetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(carDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean insertNewCar(CarDetails carDetailsNew) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(carDetailsNew);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	} 
	
	public CarDetails getCarById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(CarDetails.class);
		cr.add(Restrictions.eq("carID", id));
		List<CarDetails> carbyid=cr.list();
		return carbyid.get(0);
	}
	
	public boolean update(CarDetails carDetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(carDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}	
	
	public List<CarDetails> getPendingCars()
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(CarDetails.class);
		cr.add(Restrictions.eq("approval","pending"));
		//cr.setFirstResult(1);
		List<CarDetails> approvalCarList=cr.list();
		return approvalCarList;
	}
	
	public List<CarDetails> getOldCars(UserLogin userLogin)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(CarDetails.class);
		cr.add(Restrictions.eq("approval","approved"));
		cr.add(Restrictions.eq("status","inStock"));
		cr.add(Restrictions.eq("condition","old"));
		cr.add(Restrictions.not(Restrictions.eq("userLogin", userLogin)));
		List<CarDetails> oldcars=cr.list();
		return oldcars;
	}
	public List<CarDetails> getNewCars()
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(CarDetails.class);
		cr.add(Restrictions.eq("approval","approved"));
		cr.add(Restrictions.eq("status","inStock"));
		cr.add(Restrictions.eq("condition","new"));
		List<CarDetails> newcars=cr.list();
		return newcars;
	}
	public List<CarDetails> getMyCars(UserLogin userLogin)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(CarDetails.class);
		cr.add(Restrictions.eq("userLogin",userLogin));
		List<CarDetails> mycars=cr.list();
		return mycars;
	}
	
	
}
