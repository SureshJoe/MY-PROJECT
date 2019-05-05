package com.niitproject.DAOTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitproject.DAO.ProductDAO;
import com.niitproject.Sections.Product;

public class ProductDAOTest {
	static ProductDAO productDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niitproject");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(01);
		product.setSupplierId(0001);
		product.setCategoryId(0001);
		product.setPrice(150000);
		product.setStock(10);
		product.setProductName("Yamaha");
		product.setProductDescription("R15 new version");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(1));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(26);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
 
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(24);
		product.setPrice(699);
		product.setStock(9);
		product.setProductDescription("Lenovo Disk");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.getProductList();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+" ");
			System.out.print(product.getPrice()+" ");
			System.out.println(product.getProductDescription());
		}
	}
}
