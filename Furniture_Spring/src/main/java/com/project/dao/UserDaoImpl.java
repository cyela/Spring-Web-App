package com.project.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.project.dao.UserDao;
import com.project.model.Address;
import com.project.model.BufCart;
import com.project.model.Cart;
import com.project.model.OrderPlaced;
import com.project.model.PasswordUtil;
import com.project.model.Product;
import com.project.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException
	{
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	//====================USER MODEL=================================//
	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource paramsource=new MapSqlParameterSource();
		if(user!=null) {
			
			try {
				paramsource.addValue("email", user.getEmail());
				paramsource.addValue("firstname", user.getFirstName());
				paramsource.addValue("lastname", user.getLastName());
				paramsource.addValue("phonenumber", user.getPhonenumber());
				PasswordUtil putil=new PasswordUtil();
				String salt=putil.getSalt();
				String newPass=putil.hashAndSaltPassword(user.getPassword(), salt);
				paramsource.addValue("password",newPass );
				paramsource.addValue("salt", salt);
				paramsource.addValue("birthdate", user.getDOB());
				paramsource.addValue("gender", user.getGender());
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return paramsource;
	}
	
	private static final class UserMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs,int rowNum)throws SQLException{
			if(rs!=null) {
			User user =new User();
			user.setEmail(rs.getString("email"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setPhonenumber(rs.getString("phonenumber"));
			user.setPassword(rs.getString("password"));
			user.setSalt(rs.getString("salt"));
			user.setDOB(rs.getString("birthdate"));
			user.setGender(rs.getString("gender"));
			
			return user;
			}else {
				return null;
			}
		}
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into User(email,firstname,lastname,phonenumber,password,salt,birthdate,gender) "
				+ "values(:email,:firstname,:lastname,:phonenumber,:password,:salt,:birthdate,:gender)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	@Override
	public User findUserBy(String email) {
		// TODO Auto-generated method stub
		String sql="Select * from User where email=:email";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(email)), new UserMapper());
		
	}
	@Override
	public User findAdminBy(String email) {
		// TODO Auto-generated method stub
		String sql="Select *from Admin where email=:email";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(email)), new UserMapper());
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from User "; 
		List<User> list=namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		
		return list;
	}

	@Override
	public List<User> listAllAdmin() {
		// TODO Auto-generated method stub
		String sql="select * from Admin "; 
		List<User> list=namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		
		return list;
	}
	//=========================PRODUCT MODEL==========================//
	private SqlParameterSource getSqlParameterByModelProd(Product prod) {
		MapSqlParameterSource paramsource=new MapSqlParameterSource();
		if(prod!=null) {
			
			paramsource.addValue("productId", prod.getProductId());
			paramsource.addValue("description", prod.getDescription());
			paramsource.addValue("productname", prod.getProductname());
			paramsource.addValue("productprice", prod.getProductprice());
			paramsource.addValue("quantity", prod.getQuantity());
		}
		return paramsource;
	}
	private static final class ProductMapper implements RowMapper<Product>{
		public Product mapRow(ResultSet rs,int rowNum)throws SQLException{
			if(rs!=null) {
			Product prod =new Product();
			prod.setProductId(rs.getString("productId"));
			prod.setDescription(rs.getString("description"));
			prod.setProductname(rs.getString("productname"));
			prod.setProductprice(rs.getString("productprice"));
			prod.setQuantity(rs.getString("quantity"));
			
			
			return prod;
			}else {
				return null;
			}
		}
	}
	
	@Override
	public List<Product> listAllProducts() {
		String sql="select productId,description,productname,productprice,quantity from Product "; 
		List<Product> list=namedParameterJdbcTemplate.query(sql, getSqlParameterByModelProd(null), new ProductMapper());
		
		return list;
	}
	
	@Override
	public Product getProduct(String prodId) {
		// TODO Auto-generated method stub
		String sql="select * from Product where productId=:productId "; 
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModelProd(new Product(prodId)), new ProductMapper());
	}
	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		String sql="insert into Product(productId,description,productname,productprice,quantity) "
				+ "values(:productId,:description,:productname,:productprice,:quantity)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelProd(prod));
	}

	@Override
	public void editProduct(Product prod) {
		// TODO Auto-generated method stub
		String sql="update Product set description =:description,productname=:productname,productprice=:productprice,quantity=:quantity where productId=:productId";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("description", prod.getDescription())
				.addValue("productname", prod.getProductname())
				.addValue("productprice", prod.getProductprice())
				.addValue("quantity", prod.getQuantity())
				.addValue("productId", prod.getProductId());
		
		int status=namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}

	@Override
	public void delProduct(String prod) {
		// TODO Auto-generated method stub
		String sql="delete from  Product where productId=:productId ";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("productId", prod);
        int status = namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	//========================BUFCART MODEL=======================================//
		private SqlParameterSource getSqlParameterByModelBuf(BufCart buf) {
			MapSqlParameterSource paramsource=new MapSqlParameterSource();
			if(buf!=null) {
				
				paramsource.addValue("productId", buf.getProductId());
				paramsource.addValue("email", buf.getEmail());
				paramsource.addValue("price", buf.getPrice());
				paramsource.addValue("productname", buf.getProductName());
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				paramsource.addValue("dateAdded", dateFormat.format(date));
				paramsource.addValue("quantity", buf.getQuantity());
			}
			return paramsource;
		}
		
		private static final class BufCartMapper implements RowMapper<BufCart>{
			public BufCart mapRow(ResultSet rs,int rowNum)throws SQLException{
				if(rs!=null) {
					BufCart buf =new BufCart();
					buf.setProductId(rs.getString("productId"));
					buf.setProductName(rs.getString("productname"));
					buf.setEmail(rs.getString("email"));
					buf.setPrice(rs.getString("price"));
					buf.setDateAdded(rs.getString("dateAdded"));
					buf.setQuantity(rs.getString("quantity"));
				return buf;
				}else {
					return null;
				}
			}
		}
	
		@Override
		public void addToCart(BufCart bufcart) {
			// TODO Auto-generated method stub
			String sql="insert into BufCart(productId,productname,email,price,dateAdded,quantity) "
					+ "values(:productId,:productname,:email,:price,:dateAdded,:quantity)";
			namedParameterJdbcTemplate.update(sql, getSqlParameterByModelBuf(bufcart));
		}
		
		@Override
		public List<BufCart> listAllBufCart(String email) {
			// TODO Auto-generated method stub
			String sql="select productId,productname,price,dateAdded,quantity,email from BufCart where email=:email "; 
			List<BufCart> list=namedParameterJdbcTemplate.query(sql, getSqlParameterByModelBuf(new BufCart(email)), new BufCartMapper());
			return list;
		}
		
		@Override
		public void updateQuantity(String productId, String quantity,String email) {
			// TODO Auto-generated method stub
			String sql="update BufCart set quantity =:quantity where productId=:productId and email=:email";
			
			SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("quantity", quantity).addValue("productId", productId).addValue("email", email);
			
			int status=namedParameterJdbcTemplate.update(sql, namedParameters);
			System.out.println("rresult"+status);
		}
		
		@Override
		public void removeItem(String productId, String email) {
			// TODO Auto-generated method stub
			String sql="delete from  BufCart where productId=:productId and email=:email";
			SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("productId", productId).addValue("email", email);
	        int status = namedParameterJdbcTemplate.update(sql, namedParameters);
			
		}
		
		@Override
		public void placeOrder(OrderPlaced opd) {
			// TODO Auto-generated method stub
			String sql="insert into OrderPlaced(orderId,email,totalCost,orderDate,orderStatus) "
					+ "values(:orderId,:email,:totalCost,:orderDate,:orderStatus)";
		
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("orderId", opd.getOrderId())
					.addValue("email", opd.getEmail())
					.addValue("totalCost", opd.getTotalCost())
					.addValue("orderDate", opd.getOrderDate())
					.addValue("orderStatus", opd.getOrderStatus());
			
			int status = namedParameterJdbcTemplate.update(sql, namedParameters);
		}

		@Override
		public void addCartOrder(Cart cart) {
			// TODO Auto-generated method stub
			String sql="insert into cartitems(productId,quan,dateAdded,orderId,price) "
					+ "values(:productId,:quan,:dateAdded,:orderId,:price)";
		
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("productId", cart.getProductId())
					.addValue("quan", cart.getQuantity())
					.addValue("dateAdded", cart.getDateAdded())
					.addValue("orderId", cart.getOrderId())
					.addValue("price", cart.getPrice());
			
			int status = namedParameterJdbcTemplate.update(sql, namedParameters);
			
		}


	//=========================ADDRESS MODEL=======================================//
	private SqlParameterSource getSqlParameterByModelAddress(Address addr) {
		MapSqlParameterSource paramsource=new MapSqlParameterSource();
		if(addr!=null) {
			
			paramsource.addValue("address",addr.getAddress() );
			paramsource.addValue("city", addr.getCity());
			paramsource.addValue("state",addr.getState() );
			paramsource.addValue("zipcode", addr.getZipcode());
			paramsource.addValue("email", addr.getEmail());
		}
		return paramsource;
	}

	private static final class AddressMapper implements RowMapper<Address>{
		public Address mapRow(ResultSet rs,int rowNum)throws SQLException{
			if(rs!=null) {
			Address addr =new Address();
			addr.setAddress(rs.getString("address"));
			addr.setCity(rs.getString("city"));
			addr.setState(rs.getString("state"));
			addr.setZipcode(rs.getString("zipcode"));
			addr.setEmail(rs.getString("email"));
			return addr;
			}else {
				return null;
			}
		}
	}
	
	
	@Override
	public Address getAddress(String email) {
		// TODO Auto-generated method stub
		String sql="Select * from Address where email=:email";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModelAddress(new Address(email)), new AddressMapper());
		
	}
	@Override
	public void addAddress(Address addr) {
		// TODO Auto-generated method stub
		String sql="insert into Address(address,city,state,zipcode,email) "
				+ "values(:address,:city,:state,:zipcode,:email)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelAddress(addr));
	}
	@Override
	public void updateAddress(Address addr) {
		// TODO Auto-generated method stub
		
	}

	
	
}
