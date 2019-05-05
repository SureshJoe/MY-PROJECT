package com.niitproject.DAOTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitproject.DAO.CategoryDAO;
import com.niitproject.Sections.Category;

public class CategoryDAOTest {
	static CategoryDAO categoryDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niitproject");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("YAMAHA");
		category.setCategoryDescription("YAMAHA R15 VISION 2");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
    
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryName("yamaha");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}

	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategoryList();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+" ");
			System.out.print(category.getCategoryName()+" ");
			System.out.println(category.getCategoryDescription());
		}
	}
}
