package com.priyank.spring.sellandbuycar.dao;

import com.priyank.spring.sellandbuycar.model.*;

public interface OfficeLoginDao {
	OfficeLogin getEmpByName(int id,String pass);

}
