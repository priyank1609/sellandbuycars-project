package com.priyank.spring.sellandbuycar.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.priyank.spring.sellandbuycar.dao.CarDetailsDao;
import com.priyank.spring.sellandbuycar.dao.OfficeLoginDao;
import com.priyank.spring.sellandbuycar.dao.OrderDetailsDao;
import com.priyank.spring.sellandbuycar.dao.UserLoginDao;
import com.priyank.spring.sellandbuycar.model.CarDetails;
import com.priyank.spring.sellandbuycar.model.OrderDetails;
import com.priyank.spring.sellandbuycar.model.UserLogin;

@Controller
public class HomeController {
	@Autowired
	UserLoginDao userLoginDao;
	@Autowired
	OfficeLoginDao officeLoginDao;
	@Autowired
	CarDetailsDao carDetailsDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String getUserLogin() {
		return "userlogin";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		return "register";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String createUser(HttpServletRequest request) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserID(request.getParameter("userID"));
		userLogin.setUsername(request.getParameter("userName"));
		userLogin.setPassword(request.getParameter("userPass"));
		String phone = request.getParameter("userPhone");
		int ph = Integer.parseInt(phone);
		userLogin.setPhone(ph);
		userLogin.setEmail(request.getParameter("userEmail"));
		userLogin.setAddress(request.getParameter("userAddress"));
		userLogin.setRole("user");
		userLoginDao.insertUser(userLogin);
		return "redirect:/index";
	}

	@RequestMapping(value = "/usersignin", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request, RedirectAttributes rd, ModelMap model) {
		String uid = request.getParameter("userID");
		String upass = request.getParameter("userPassword");
		UserLogin user = userLoginDao.getUserByName(uid, upass);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "userhome";
		} else {
			rd.addFlashAttribute("message", "failed to login userid and password do not match");
			return "redirect:/userlogin";
		}
	}

	@RequestMapping(value = "/dologout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/useraddoldcar", method = RequestMethod.GET)
	public String getUserAddOldcar() {
		return "user_addoldcar";
	}

	@RequestMapping(value = "/uhome", method = RequestMethod.GET)
	public String getUhome() {
		return "userhome";
	}

	@RequestMapping(value = "/useraddoldcar", method = RequestMethod.POST)
	public String createOldCar(HttpServletRequest request, @RequestParam CommonsMultipartFile imageupload,
			HttpSession session) {
		CarDetails carDetails = new CarDetails();
		carDetails.setApproval("pending");
		carDetails.setCarCompany(request.getParameter("car_Company"));
		carDetails.setCarModel(request.getParameter("car_Model"));
		carDetails.setCondition("old");
		carDetails.setFuelType(request.getParameter("car_FuelType"));
		String CFT = request.getParameter("car_KMDriven");
		int cft = Integer.parseInt(CFT);
		carDetails.setKm_driven(cft);
		String Pricing = request.getParameter("car_Pricing");
		int price = Integer.parseInt(Pricing);
		carDetails.setPricing(price);
		carDetails.setStatus("inStock");
		carDetails.setUserLogin((UserLogin) request.getSession().getAttribute("user"));
		String path = session.getServletContext().getRealPath("/") +"assets"+File.separator+"images"+File.separator+
				imageupload.getOriginalFilename();
		System.out.println(path);
		try {
			byte barr[] = imageupload.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) 
		{
			System.out.println(e);
		}
		carDetails.setImage(imageupload.getOriginalFilename());
		carDetailsDao.insertOldCar(carDetails);
		return "redirect:/uhome";
	}

	@RequestMapping(value = "/user_shop", method = RequestMethod.GET)
	public String getUserShop() {
		return "usershop";
	}

	@RequestMapping(value = "/shop_old_cars", method = RequestMethod.GET)
	public String getCarsShopOld(HttpServletRequest request, RedirectAttributes rd, Model model,HttpSession session) {
		UserLogin user = (UserLogin) request.getSession().getAttribute("user");
		model.addAttribute("oldcarlist", carDetailsDao.getOldCars(user));
		return "usershop";
	}

	@RequestMapping(value = "/shop_new_cars", method = RequestMethod.GET)
	public String getCarsShopNew(HttpServletRequest request, RedirectAttributes rd, Model model) {
		model.addAttribute("newcarlist", carDetailsDao.getNewCars());
		return "usershop";
	}

	@RequestMapping(value = "/user_buy_car/{carid}", method = RequestMethod.GET)
	public String getBuyCar(HttpServletRequest request, RedirectAttributes rd, Model model,
			@PathVariable("carid") int carid) {
		model.addAttribute("car_id", carid);
		return "userbuycar";
	}

	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public String addOrder(HttpServletRequest request, RedirectAttributes rd) {
		String cid = request.getParameter("carID");
		int CID = Integer.parseInt(cid);
		CarDetails car1 = carDetailsDao.getCarById(CID);
		OrderDetails orderDetails = new OrderDetails();
		long millis = System.currentTimeMillis();
		java.util.Date date = new java.util.Date(millis);
		orderDetails.setOrderDate(date);
		orderDetails.setStatus("pending");
		orderDetails.setCarDetails(car1);
		orderDetails.setUserlogin((UserLogin) request.getSession().getAttribute("user"));
		orderDetails.setAddress(request.getParameter("orderAddress"));
		orderDetails.setMode(request.getParameter("mode"));
		orderDetailsDao.insertOrder(orderDetails);
		car1.setStatus("booked");
		carDetailsDao.update(car1);
		return "redirect:/uhome";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getOrders() {
		return "myorders";
	}

	@RequestMapping(value = "/view_my_orders", method = RequestMethod.GET)
	public String getMyOrders(HttpServletRequest request, RedirectAttributes rd, Model model) {
		UserLogin user = (UserLogin) request.getSession().getAttribute("user");
		model.addAttribute("myorders", orderDetailsDao.getOrderByUserID(user));
		return "myorders";
	}

	@RequestMapping(value = "/viewmycars", method = RequestMethod.GET)
	public String getMyCars() {
		return "viewcars";
	}

	@RequestMapping(value = "/view_my_cars", method = RequestMethod.GET)
	public String getMyCars(HttpServletRequest request, RedirectAttributes rd, Model model) {
		UserLogin user = (UserLogin) request.getSession().getAttribute("user");
		model.addAttribute("myallcars", carDetailsDao.getMyCars(user));
		return "viewcars";
	}

}
