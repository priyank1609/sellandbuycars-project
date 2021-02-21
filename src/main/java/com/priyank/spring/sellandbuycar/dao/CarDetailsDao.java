package com.priyank.spring.sellandbuycar.dao;

import java.util.List;

import com.priyank.spring.sellandbuycar.model.UserLogin;
import com.priyank.spring.sellandbuycar.model.CarDetails;

public interface CarDetailsDao {
	boolean insertOldCar(CarDetails carDetails);
	List<CarDetails> getPendingCars();
	CarDetails getCarById(int id);
	boolean update(CarDetails carDetails);
	boolean insertNewCar(CarDetails carDetailsNew);
	List<CarDetails> getOldCars(UserLogin userLogin);
	List<CarDetails> getNewCars();
	List<CarDetails> getMyCars(UserLogin userLogin);
}
