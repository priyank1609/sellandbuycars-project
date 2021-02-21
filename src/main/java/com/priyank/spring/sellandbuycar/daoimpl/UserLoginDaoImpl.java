package com.priyank.spring.sellandbuycar.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priyank.spring.sellandbuycar.dao.*;
import com.priyank.spring.sellandbuycar.model.*;

@Repository("userLoginDao")
@Transactional
public class UserLoginDaoImpl implements UserLoginDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertUser(UserLogin userLogin)
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(userLogin);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public UserLogin getUserByName(String id,String pass)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(UserLogin.class);
		cr.add(Restrictions.eq("userID", id));
		cr.add(Restrictions.eq("password", pass));
		//cr.setFirstResult(1);
		List<UserLogin> userList=cr.list();
		System.out.println("Size of the list is "+userList.size());
		if(userList.size()==1)
		{
			System.out.println("User details:"+userList.get(0).getUsername());
			return userList.get(0);
		}
		else
		{
			return null;
		}
	}

}
