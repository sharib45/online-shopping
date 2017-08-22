package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public static List<Category> categories = new ArrayList<>();
	
  static	{
		
	  Category category =  new Category();
	  category.setId(1);
	  category.setName("mobile");
	  category.setDescription("this is mobile");
	  category.setImageURL("CAT_1.png");
	  
	  categories.add(category);
	  
	  category =  new Category();
	  category.setId(2);
	  category.setName("tv");
	  category.setDescription("this is tv");
	  category.setImageURL("CAT_2.png");
	  
	  categories.add(category);
		
	  category =  new Category();
	  category.setId(3);
	  category.setName("lap");
	  category.setDescription("this is lap");
	  category.setImageURL("CAT_3.png");
	  
	  categories.add(category);
	  
	}*/

	@Override
	public List<Category> list() {
		
String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
