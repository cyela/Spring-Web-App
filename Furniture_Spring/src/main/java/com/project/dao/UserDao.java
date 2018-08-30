package com.project.dao;

import java.util.List;

import com.project.model.Address;
import com.project.model.BufCart;
import com.project.model.Cart;
import com.project.model.OrderPlaced;
import com.project.model.Product;
import com.project.model.User;

public interface UserDao {

	public void addUser(User user);
	public User findUserBy(String email);
	public User findAdminBy(String email);
	public List<User> listAllUser();
	public List<User> listAllAdmin();
	
	
	public void addAddress(Address addr);
	public void updateAddress(Address addr);
	public Address getAddress(String email);
	
	public List<Product> listAllProducts();
	public Product getProduct(String prodId);
	public void addProduct(Product prod);
	public void editProduct(Product prod);
	public void delProduct(String prod);
	
	public void addToCart(BufCart bufcart);
	public List<BufCart> listAllBufCart(String email);
	public void updateQuantity(String productId,String quantity,String email);
	public void removeItem(String productId, String email);
	
	
	public void placeOrder(OrderPlaced opd);
	public void addCartOrder(Cart cart);
	
	
}
