package com.niitproject.Configure;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niitproject.DAO.CartDAO;
import com.niitproject.DAO.CartDAOimpl;
import com.niitproject.DAO.CategoryDAO;
import com.niitproject.DAO.CategoryDAOimpl;
import com.niitproject.DAO.ProductDAO;
import com.niitproject.DAO.ProductDAOimpl;
import com.niitproject.DAO.SupplierDAO;
import com.niitproject.DAO.SupplierDAOimpl;
import com.niitproject.DAO.UserDAO;
import com.niitproject.DAO.UserDAOimpl;
import com.niitproject.Sections.Cart;
import com.niitproject.Sections.Category;
import com.niitproject.Sections.Product;
import com.niitproject.Sections.Supplier;
import com.niitproject.Sections.User;

 	
@Configuration
@ComponentScan("com.niitproject.*")
@EnableTransactionManagement  

public class DBConfigure {    
 	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		System.out.println("data source");
	DriverManagerDataSource dataSource = new DriverManagerDataSource();   
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/E:/H2/table4/table");	
	dataSource.setUsername("joe");
	dataSource.setPassword("joe");
	 
	    return dataSource;
	}

	private Properties getHibernateProperties() {	
		System.out.println("get hibernate");
		Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");	
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("session factory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource); 
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);          
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("Transaction manager");
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager;
	}
	
	  @Bean(name="categoryDAO") public CategoryDAO getCategoryDAO() { return new
	  CategoryDAOimpl();} 
	  @Bean(name="supplierDAO") public SupplierDAO getSupplierDAO() { return new
			  SupplierDAOimpl();}
	  @Bean(name="productyDAO") public ProductDAO getProductDAO() { return new
			  ProductDAOimpl();}
	  @Bean(name="cartDAO") 
	  public CartDAO getCartDAO() {
	  	System.out.println("Cart DAO Implementation");
	  	return new CartDAOimpl();
	  }
	  @Bean(name="userDAO") 
	  public UserDAO getUserDAO() {
	  	System.out.println("User DAO Implementation");
	  	return new UserDAOimpl();
	 
}
}