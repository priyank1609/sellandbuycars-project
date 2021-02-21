package com.priyank.spring.sellandbuycar.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.priyank.spring.sellandbuycar.dao.CarDetailsDao;
import com.priyank.spring.sellandbuycar.dao.OfficeLoginDao;
import com.priyank.spring.sellandbuycar.dao.OrderDetailsDao;
import com.priyank.spring.sellandbuycar.dao.UserLoginDao;
import com.priyank.spring.sellandbuycar.model.CarDetails;
import com.priyank.spring.sellandbuycar.model.OfficeLogin;
import com.priyank.spring.sellandbuycar.model.OrderDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserLoginDao userLoginDao;
	@Autowired
	OfficeLoginDao officeLoginDao;
	@Autowired
	CarDetailsDao carDetailsDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	
	@RequestMapping(value = "/login" ,method=RequestMethod.GET)
	public String getAdminLogin()
	{
		return "adminlogin";
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String doLogin2(HttpServletRequest request, RedirectAttributes rd)
	{
		String eID=request.getParameter("empID");
		int eid=Integer.parseInt(eID);
		String epass=request.getParameter("empPassword");
		OfficeLogin office=officeLoginDao.getEmpByName(eid,epass);
		if(office!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("office",office );
			return "adminhome";
		}
		else
		{
			rd.addFlashAttribute("message", "failed to login userid and password do not match");
			return "redirect:/admin/login";
		}
	}
	
	@RequestMapping(value = "/home" ,method=RequestMethod.GET)
	public String getAHome()
	{
		return "adminhome";
	}
	@RequestMapping(value = "/view_approvals" ,method=RequestMethod.GET)
	public String getApprovalList()
	{
		return "viewapprovals";
	}
	@RequestMapping(value = "/add_newcar" ,method=RequestMethod.GET)
	public String getNewCar()
	{
		return "addnewcar";
	}
	
	@RequestMapping(value="/view_cars_approval",method=RequestMethod.GET)
	public String getCarsApproval(HttpServletRequest request, RedirectAttributes rd,Model model)
	{
		model.addAttribute("approvalList",carDetailsDao.getPendingCars());
		return "viewapprovals";
	}
	@RequestMapping(value="/update/{carid}/{status}",method=RequestMethod.GET)
	public String update(HttpServletRequest request, RedirectAttributes rd,Model model,@PathVariable("carid")int carid,@PathVariable("status")String approval)
	{
		String reas=request.getParameter("Reason");
		CarDetails car=carDetailsDao.getCarById(carid);
		car.setApproval(approval);
		car.setRej_reason(reas);
		carDetailsDao.update(car);
		return "adminhome";
	}
	
	@RequestMapping(value = "/addCar" ,method=RequestMethod.POST)
	public String createNewCar(HttpServletRequest request)
	{
		CarDetails carDetails=new CarDetails();
		carDetails.setApproval("approved");
		carDetails.setCarCompany(request.getParameter("newCarCompany"));
		carDetails.setCarModel(request.getParameter("newCarModel"));
		carDetails.setCondition("new");
		carDetails.setFuelType(request.getParameter("newCarFuelType"));
		carDetails.setKm_driven(0);
		String Pricing=request.getParameter("newCarPricing");
		int price=Integer.parseInt(Pricing);
		carDetails.setPricing(price);
		carDetails.setStatus("inStock");
		carDetailsDao.insertNewCar(carDetails);
		return "adminhome";
	}
	@RequestMapping(value = "/viewOrders" ,method=RequestMethod.GET)
	public String getNewOrders()
	{
		return "vieworders";
	}
	@RequestMapping(value="/view_new_orders",method=RequestMethod.GET)
	public String getNewOrdersDetails(HttpServletRequest request, RedirectAttributes rd,Model model)
	{
		model.addAttribute("orderList",orderDetailsDao.getPendingOrders());
		return "vieworders";
	}
	
	@RequestMapping(value="/updateorder/{orderid}/{carid}",method=RequestMethod.GET)
	public String updateOrder(HttpServletRequest request, RedirectAttributes rd,Model model,@PathVariable("orderid")int orderid,@PathVariable("carid")int carid)
	{
		OrderDetails order=orderDetailsDao.getOrderById(orderid);
		CarDetails car3=carDetailsDao.getCarById(carid);
		long millis=System.currentTimeMillis();  
		java.util.Date deldate=new java.util.Date(millis);
		order.setDelDate(deldate);
		order.setStatus("completed");
		orderDetailsDao.update(order);
		car3.setStatus("soldout");
		carDetailsDao.update(car3);
		return "adminhome";
	}
	
	@RequestMapping(value="/dologout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/index";
	}
}
