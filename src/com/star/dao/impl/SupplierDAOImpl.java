package com.star.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import com.star.dao.ISupplierDAO;
import com.star.domain.Supplier;

public class SupplierDAOImpl extends BaseDAOImpl<Supplier> implements ISupplierDAO{

	@Override
	public List<Object[]> getIndustryCount() {
		// TODO Auto-generated method stub
		//使用原生SQL进行查询
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			String sql = "SELECT                                 "+
						"bd.dict_item_name,                      "+
						"COUNT(*) total                          "+
						"FROM supplier s,base_dict bd            "+
						"WHERE s.supplier_industry = bd.dict_id  "+
						"GROUP BY s.supplier_industry            ";
			
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		
		return list;
		
	}
	

}
