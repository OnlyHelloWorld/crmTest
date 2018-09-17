package com.star.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.star.dao.ICustomerDAO;
import com.star.domain.Customer;

public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements ICustomerDAO{


	public List<Object[]> getIndustryCount() {
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			
			String sql =   " SELECT bd.dict_item_name,COUNT(*) total "+
						" FROM cst_customer c,base_dict bd         "+
					       " WHERE c.cust_industry = bd.dict_id      "+
					       " GROUP BY c.cust_industry                ";
			
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				
				SQLQuery query = session.createSQLQuery(sql);
				
				return query.list();
			}
		});
		return list;
	}

}
