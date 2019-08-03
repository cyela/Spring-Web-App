package com.project.dao;

import java.util.List;

import com.hiber.model.Address;
import com.hiber.model.Admin;
import com.hiber.model.Bufcart;
import com.hiber.model.OrderPlaced;
import com.hiber.model.Product;
import com.hiber.model.User;

public interface UserDao {

	public void addUser(User user);

	public User findUserBy(String email);

	public Admin findAdminBy(String email);

	public List<User> listAllUser();

	public List<Admin> listAllAdmin();

	public void addAddress(Address addr);

	public Address getAddress(String email);

	public List<Product> listAllProducts();

	public Product getProduct(String prodId);

	public void addProduct(Product prod);

	public void editProduct(Product prod);

	public void delProduct(String prod);

	public void addToCart(Bufcart bufcart);

	public List<Bufcart> listAllBufCart(String email);

	public void removeItem(int bufcartId);

	public void placeOrder(OrderPlaced opd);

}
