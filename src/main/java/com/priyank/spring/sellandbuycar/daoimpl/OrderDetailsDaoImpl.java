package com.priyank.spring.sellandbuycar.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priyank.spring.sellandbuycar.dao.OrderDetailsDao;
import com.priyank.spring.sellandbuycar.model.CarDetails;
import com.priyank.spring.sellandbuycar.model.OrderDetails;
import com.priyank.spring.sellandbuycar.model.UserLogin;

@Repository("orderDetailsDao")
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertOrder(OrderDetails orderDetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(orderDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public List<OrderDetails> getPendingOrders()
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(OrderDetails.class);
		cr.add(Restrictions.eq("status","pending"));
		List<OrderDetails> pendingOrderList=cr.list();
		return pendingOrderList;
	}
	public OrderDetails getOrderById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(OrderDetails.class);
		cr.add(Restrictions.eq("orderID", id));
		List<OrderDetails> orderbyid=cr.list();
		return orderbyid.get(0);
	}
	public boolean update(OrderDetails orderDetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(orderDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public List<OrderDetails> getOrderByUserID(UserLogin userLogin)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(OrderDetails.class);
		cr.add(Restrictions.eq("userLogin", userLogin));
		List<OrderDetails> orderbyuserid=cr.list();
		return orderbyuserid;
	}
}
