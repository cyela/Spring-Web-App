package com.project.controller;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hiber.model.Address;
import com.hiber.model.Admin;
import com.hiber.model.Bufcart;
import com.hiber.model.OrderPlaced;
import com.hiber.model.Product;
import com.hiber.model.User;
import com.project.service.UserService;
import com.project.util.PasswordUtil;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("useremail")
public class HomeController {

	@Autowired
	private UserService userService;

	// ==========NAVIGATION TO LOGIN PAGE========================//
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginView() {

		ModelAndView model = new ModelAndView("login");
		User user = new User();
		model.addObject("userloginform", user);
		return model;

	}

	// ==================VERIFYING CREDENTIALS AND REDIRECTING TO USER HOME
	// PAGE========================//
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("userloginform") User user, HttpSession session)
			throws NoSuchAlgorithmException {
		List<User> AllUser = userService.listAllUser();
		List<Admin> AllAdmin = userService.listAllAdmin();
		boolean index = false;
		for (int i = 0; i < AllUser.size(); i++) {
			if (AllUser.get(i).getEmail().equals(user.getEmail())) {
				index = true;
			}
		}
		if (!index) {
			boolean indexsec = false;
			for (int i = 0; i < AllAdmin.size(); i++) {
				if (AllAdmin.get(i).getEmail().equals(user.getEmail())) {
					indexsec = true;
				}
			}
			if (indexsec) {
				Admin userfa = userService.findAdminBy(user.getEmail());
				if (userfa.getPassword().equals(user.getPassword())) {
					ModelAndView model = new ModelAndView("adminPage");
					List<Product> list = userService.listAllProducts();
					// System.out.println(list.toString());
					Product prod = new Product();
					model.addObject("productform", prod);
					model.addObject("useremail", user.getEmail());
					model.addObject("listAdminProduct", list);
					session.setAttribute("user", user.getEmail());
					return model;
				}
			}
		} else {
			User userf = userService.findUserBy(user.getEmail());
			if (PasswordUtil.hashAndSaltPassword(user.getPassword(), userf.getSalt()).equals(userf.getPassword())) {

				ModelAndView model = new ModelAndView("userPage");
				List<Product> list = userService.listAllProducts();
				model.addObject("useremail", user.getEmail());
				model.addObject("listProduct", list);
				session.setAttribute("user", user.getEmail());
				return model;
			}
		}
		return new ModelAndView("redirect:/user/login");
	}

	// ==========================REDIRECTING TO USER HOME
	// PAGE=====================================//
	@RequestMapping(value = "/home")
	public ModelAndView homeDirect(HttpSession session) throws NoSuchAlgorithmException {

		ModelAndView model = new ModelAndView("userPage");
		List<Product> list = userService.listAllProducts();

		model.addObject("useremail", session.getAttribute("user"));
		model.addObject("listProduct", list);
		session.setAttribute("user", session.getAttribute("user"));
		return model;

	}

	// ======================LOGGING OUT FROM
	// SESSION===============================================//
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {

		session.invalidate();
		if (model.containsAttribute("useremail"))
			model.asMap().remove("useremail");
		return "redirect:/user/login";
	}

	// ========================NAVIGATING TO SIGN UP
	// PAGE============================================//
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupView() {

		ModelAndView model = new ModelAndView("signup");
		User user = new User();
		model.addObject("usersignform", user);
		return model;

	}

	// ====================REGESTERING DETAILS AND REDIRECTING TO WEBSITE HOME
	// PAGE=========================//
	@RequestMapping(value = "/savedetails", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("usersignform") User user) {
		userService.addUser(user);
		return new ModelAndView("redirect:/user/login");
	}

	// =====================NAVIGATING TO ADDRESS EDIT
	// PAGE=============================================//
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ModelAndView addressChange(HttpSession session) {

		ModelAndView model = new ModelAndView("address");
		Address addr = userService.getAddress(session.getAttribute("user").toString());
		System.out.println(addr.toString());
		model.addObject("useremail", session.getAttribute("user"));
		model.addObject("addressform", addr);
		return model;

	}

	// ===================UPDATING ADDRESS AND REDIRECTING TO USER HOME
	// PAGE=============================//
	@RequestMapping(value = "/addresschange", method = RequestMethod.POST)
	public ModelAndView addressChange(@ModelAttribute("addressform") Address addr) {
		userService.addAddress(addr);
		return new ModelAndView("redirect:/user/home");
	}

	// ==================ADDING PRODUCT TO
	// CART==============================================//
	@RequestMapping(value = "/product/{prodId}", method = RequestMethod.GET)
	public ModelAndView addtocart(@PathVariable("prodId") String prodId, HttpSession session) {

		ModelAndView model = new ModelAndView("userPage");
		List<Product> list = userService.listAllProducts();
		Bufcart buf = new Bufcart();
		buf.setProductId(prodId);
		Product prod = userService.getProduct(prodId);
		buf.setProductName(prod.getProductname());
		buf.setPrice(prod.getProductprice());
		String email = (String) session.getAttribute("user");
		buf.setEmail(email);
		buf.setQuantity("1");
		buf.setOrderId(0);
		userService.addToCart(buf);
		model.addObject("useremail", session.getAttribute("user"));
		model.addObject("listProduct", list);
		session.setAttribute("user", session.getAttribute("user"));
		return model;

	}

	// =====================NAVIGATING TO VIEW CART PAGE
	// =================================//

	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public ModelAndView viewCart(HttpSession session) {

		ModelAndView model = new ModelAndView("viewcart");
		String email = (String) session.getAttribute("user");
		List<Bufcart> list = userService.listAllBufCart(email);
		model.addObject("listBufcart", list);
		return model;

	}

	// =====================UPDATING QUANTITY IN CART
	// ITEMS====================================//

	@RequestMapping(value = "/updateQuantity", method = RequestMethod.POST)
	public ModelAndView updateQuantity(@RequestParam("newquantity") String quantity,
			@RequestParam("newprodId") String productId, HttpSession session) {

		String email = (String) session.getAttribute("user");
		ModelAndView model = new ModelAndView("viewcart");
		List<Bufcart> list = userService.listAllBufCart(email);
		list.forEach(buf -> {
			if (buf.getEmail().equals(email) && buf.getProductId().equals(productId)) {
				Bufcart bufcart = buf;
				bufcart.setQuantity(quantity);
				userService.addToCart(bufcart);
			}
		});
		model.addObject("listBufcart", list);
		return model;

	}

	// =================REMOVING ITEM FROM CART
	// ITEMS===================================================//

	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	public ModelAndView removeItem(@RequestParam("newdelprodId") String productId, HttpSession session) {

		String email = (String) session.getAttribute("user");
		ModelAndView model = new ModelAndView("viewcart");

		userService.listAllBufCart(email).forEach(buf -> {
			if (buf.getEmail().equals(email) && buf.getProductId().equals(productId)) {
				userService.removeItem(buf.getBufcartId());
			}
		});
		List<Bufcart> list = userService.listAllBufCart(email);
		model.addObject("listBufcart", list);
		return model;

	}

	// ===============PLACING
	// ORDER==================================================================//

	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public ModelAndView placeOrder(HttpSession session) {

		String email = (String) session.getAttribute("user");
		List<Bufcart> list = userService.listAllBufCart(email);

		Random rand = new Random();
		OrderPlaced opd = new OrderPlaced();
		int orderId = rand.nextInt(10000);
		opd.setOrderId(orderId);
		opd.setEmail(email);
		int tosum = 0;
		for (int i = 0; i < list.size(); i++) {
			int price = Integer.parseInt(list.get(i).getPrice());
			int quantity = Integer.parseInt(list.get(i).getQuantity());
			tosum = tosum + (price * quantity);
		}
		opd.setTotalCost(Integer.toString(tosum));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		opd.setOrderDate(dateFormat.format(date));
		opd.setOrderStatus("Pending");
		userService.placeOrder(opd);
		list.forEach(action -> {
			action.setOrderId(orderId);
			userService.addToCart(action);
		});

		return new ModelAndView("redirect:/user/home");

	}

	// ==============================ADMIN CONTROLLER
	// MODULES============================================//

	@RequestMapping(value = "/adminhome")
	public ModelAndView homeDirectAdmin(HttpSession session) throws NoSuchAlgorithmException {

		ModelAndView model = new ModelAndView("adminPage");
		List<Product> list = userService.listAllProducts();
		model.addObject("useremail", session.getAttribute("user"));
		model.addObject("listAdminProduct", list);
		session.setAttribute("user", session.getAttribute("user"));
		return model;

	}

	// ========================NAVIGATING TO ADD PRODUCT
	// PAGE============================================//
	@RequestMapping(value = "/addProductView", method = RequestMethod.GET)
	public ModelAndView addProductView() {

		ModelAndView model = new ModelAndView("addItem");
		Product prod = new Product();
		model.addObject("productform", prod);
		return model;

	}

	// =======================ADDING PRODUCT TO
	// DATABASE============================================//
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("productform") Product prod, HttpSession session) {

		// saving user details in database
		Random rand = new Random();
		System.out.println(prod.toString());
		prod.setProductId(Integer.toString(rand.nextInt(10000)));
		userService.addProduct(prod);
		return new ModelAndView("redirect:/user/adminhome");

	}

	// ========================NAVIGATING TO EDIT PRODUCT
	// PAGE============================================//
	@RequestMapping(value = "/editproduct/{prodId}", method = RequestMethod.GET)
	public ModelAndView editProductView(@PathVariable("prodId") String prodId) {

		ModelAndView model = new ModelAndView("editItem");
		Product selProd = userService.getProduct(prodId);
		System.out.println(selProd.toString());
		Product prod = new Product();
		model.addObject("productform", prod);
		model.addObject("selproduct", selProd);
		return model;

	}

	// =======================ADDING PRODUCT TO
	// DATABASE============================================//
	@RequestMapping(value = "/editProductsave", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute("productform") Product prod, HttpSession session) {

		// updating user details in database

		userService.editProduct(prod);
		return new ModelAndView("redirect:/user/adminhome");

	}

	// ========================NAVIGATING TO EDIT PRODUCT
	// PAGE============================================//
	@RequestMapping(value = "/delproduct/{prodId}", method = RequestMethod.GET)
	public ModelAndView delProductView(@PathVariable("prodId") String prodId) {

		userService.delProduct(prodId);
		return new ModelAndView("redirect:/user/adminhome");

	}
}
