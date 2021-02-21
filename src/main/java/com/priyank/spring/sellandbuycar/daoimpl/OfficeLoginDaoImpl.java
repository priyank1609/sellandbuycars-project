package com.priyank.spring.sellandbuycar.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priyank.spring.sellandbuycar.dao.OfficeLoginDao;
import com.priyank.spring.sellandbuycar.model.OfficeLogin;
import com.priyank.spring.sellandbuycar.model.UserLogin;

@Repository("officeLoginDao")
@Transactional
public class OfficeLoginDaoImpl implements OfficeLoginDao{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public OfficeLogin getEmpByName(int id,String pass)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(OfficeLogin.class);
		cr.add(Restrictions.eq("empID", id));
		cr.add(Restrictions.eq("password", pass));
		//cr.setFirstResult(1);
		List<OfficeLogin> OfficeList=cr.list();
		System.out.println("Size of the list is "+OfficeList.size());
		if(OfficeList.size()==1)
		{
			System.out.println("Office details:"+OfficeList.get(0).getUsername());
			return OfficeList.get(0);
		}
		else
		{
			return null;
		}
	}

}
