package com.priyank.spring.sellandbuycar.dao;

import java.util.List;

import com.priyank.spring.sellandbuycar.model.UserLogin;
import com.priyank.spring.sellandbuycar.model.OrderDetails;

public interface OrderDetailsDao {
	boolean insertOrder(OrderDetails orderDetails);
	List<OrderDetails> getPendingOrders();
	OrderDetails getOrderById(int id);
	boolean update(OrderDetails orderDetails);
	List<OrderDetails> getOrderByUserID(UserLogin userLogin);
}
