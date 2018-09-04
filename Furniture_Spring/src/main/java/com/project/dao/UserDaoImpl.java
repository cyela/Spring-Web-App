package com.project.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.project.dao.UserDao;
import com.hiber.model.Address;
import com.hiber.model.Admin;
import com.hiber.model.Bufcart;
import com.hiber.model.OrderPlaced;
import com.hiber.model.Product;
import com.project.util.PasswordUtil;
import com.hiber.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		PasswordUtil putil=new PasswordUtil();
		String salt=putil.getSalt();
		try {
			String newPass=putil.hashAndSaltPassword(user.getPassword(), salt);
			user.setPassword(newPass);
			user.setSalt(salt);
			session.persist(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User findUserBy(String email) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql = "FROM User WHERE email ='"+email+"'";
		
		Query query = session.createQuery(hql);
		User results = (User) query.getSingleResult();
		return results;
	}

	@Override
	public Admin findAdminBy(String email) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql = "FROM Admin WHERE email ='"+email+"'";
		
		Query query = session.createQuery(hql);
		Admin results = (Admin) query.getSingleResult();
		return results;
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		List<User> emps= session.createQuery("from User",User.class).list();
		return emps;
	}

	@Override
	public List<Admin> listAllAdmin() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		List<Admin> emps= session.createQuery("from Admin",Admin.class).list();
		return emps;
	}

	@Override
	public void addAddress(Address addr) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(addr);
	}

	@Override
	public Address getAddress(String email) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Address address= session.createQuery("from Address where email='"+email+"'",Address.class).getSingleResult();
		System.out.println(address.toString());
		return address;
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		List<Product> emps= session.createQuery("from Product",Product.class).list();
		return emps;
	}

	@Override
	public Product getProduct(String prodId) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql = "FROM Product WHERE productId ="+prodId;
		
		Query query = session.createQuery(hql);
		Product results = (Product) query.getSingleResult();
		return results;
	}

	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(prod);
	}

	@Override
	public void editProduct(Product prod) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.update(prod);
	}

	@Override
	public void delProduct(String prod) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, prod);
        session.delete(product);
	}

	@Override
	public void addToCart(Bufcart bufcart) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(bufcart);
	}

	@Override
	public List<Bufcart> listAllBufCart(String email) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		String hql = "FROM Bufcart WHERE email ='"+email+"'";
		
		Query query = session.createQuery(hql);
		List<Bufcart> results =  query.list();
		return results;
	}

	@Override
	public void removeItem(int bufcartId) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Bufcart product = (Bufcart) session.get(Bufcart.class,bufcartId );
        session.delete(product);
	}

	@Override
	public void placeOrder(OrderPlaced opd) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(opd);
	}
	
}
