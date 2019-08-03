package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiber.model.Address;
import com.hiber.model.Admin;
import com.hiber.model.Bufcart;
import com.hiber.model.OrderPlaced;
import com.hiber.model.Product;
import com.hiber.model.User;
import com.project.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

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
	public Address getAddress(String email) {
		// TODO Auto-generated method stub
		return userDao.getAddress(email);
	}

	@Override
	public void addToCart(Bufcart bufcart) {
		// TODO Auto-generated method stub
		userDao.addToCart(bufcart);
	}

	@Override
	public Product getProduct(String prodId) {
		// TODO Auto-generated method stub
		return userDao.getProduct(prodId);
	}

	@Override
	public List<Bufcart> listAllBufCart(String email) {
		// TODO Auto-generated method stub
		return userDao.listAllBufCart(email);
	}

	@Override
	public void removeItem(int bufcartId) {
		// TODO Auto-generated method stub
		userDao.removeItem(bufcartId);
	}

	@Override
	public void placeOrder(OrderPlaced opd) {
		// TODO Auto-generated method stub
		userDao.placeOrder(opd);
	}

	@Override
	public Admin findAdminBy(String email) {
		// TODO Auto-generated method stub
		return userDao.findAdminBy(email);
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}

	@Override
	public List<Admin> listAllAdmin() {
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