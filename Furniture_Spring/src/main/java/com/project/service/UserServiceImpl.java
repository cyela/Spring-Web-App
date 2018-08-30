package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.model.Address;
import com.project.model.BufCart;
import com.project.model.Cart;
import com.project.model.OrderPlaced;
import com.project.model.Product;
import com.project.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}


	@Override
	public User findUserBy(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserBy(email);
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return userDao.listAllProducts();
	}

	
	@Override
	public void addAddress(Address addr) {
		// TODO Auto-generated method stub
		userDao.addAddress(addr);
	}

	@Override
	public void updateAddress(Address addr) {
		// TODO Auto-generated method stub
		userDao.updateAddress(addr);
	}

	@Override
	public Address getAddress(String email) {
		// TODO Auto-generated method stub
		return userDao.getAddress(email);
	}

	@Override
	public void addToCart(BufCart bufcart) {
		// TODO Auto-generated method stub
		userDao.addToCart(bufcart);
	}


	@Override
	public Product getProduct(String prodId) {
		// TODO Auto-generated method stub
		return userDao.getProduct(prodId);
	}


	@Override
	public List<BufCart> listAllBufCart(String email) {
		// TODO Auto-generated method stub
		return userDao.listAllBufCart(email);
	}


	@Override
	public void updateQuantity(String productId, String quantity,String email) {
		// TODO Auto-generated method stub
		userDao.updateQuantity(productId, quantity, email);
	}


	@Override
	public void removeItem(String productId, String email) {
		// TODO Auto-generated method stub
		userDao.removeItem(productId, email);
	}


	@Override
	public void placeOrder(OrderPlaced opd) {
		// TODO Auto-generated method stub
		userDao.placeOrder(opd);
	}


	@Override
	public void addCartOrder(Cart cart) {
		// TODO Auto-generated method stub
		userDao.addCartOrder(cart);
	}


	@Override
	public User findAdminBy(String email) {
		// TODO Auto-generated method stub
		return userDao.findAdminBy(email);
	}


	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}


	@Override
	public List<User> listAllAdmin() {
		// TODO Auto-generated method stub
		return userDao.listAllAdmin();
	}


	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		userDao.addProduct(prod);
	}


	@Override
	public void editProduct(Product prod) {
		// TODO Auto-generated method stub
		userDao.editProduct(prod);
	}


	@Override
	public void delProduct(String prod) {
		// TODO Auto-generated method stub
		userDao.delProduct(prod);
	}

	

}
