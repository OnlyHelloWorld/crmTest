package com.star.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.star.dao.IUserDAO;
import com.star.domain.User;
import com.star.service.IUserService;
import com.star.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Resource(name="userDAO")
	private IUserDAO userDAO;
	
	@Test
	//≤‚ ‘DAO Hibernateƒ£∞Â
	public void fun1() {
		Configuration conf = new Configuration().configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = userDAO.getByUserCode("tom");
		System.out.println(user);
		tx.commit();
		session.close();
		sf.close();
	}
	
	@Resource(name="userService")
	private IUserService userService;
	
	@Test
	//≤‚ ‘AOP ¬ŒÒ
	public void fun2() {
		User u = new User();
		u.setUser_code("kkk");
		u.setUser_name("shen");
		u.setUser_password("1234");
	
		userService.saveUser(u);
	}
}
