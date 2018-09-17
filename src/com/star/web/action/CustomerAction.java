package com.star.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.Customer;
import com.star.domain.User;
import com.star.service.ICustomerService;
import com.star.utils.PageBean;
import com.sun.org.apache.regexp.internal.recompile;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	
	private ICustomerService customerService;
	//Ϊ�ļ��ϴ���׼��,׼������,�㶨
	private File photo;
	private String photoFileName;
	
	private Integer currentPage;
	private Integer pageSize;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//�жϲ���װ����
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
					
		}
		//����Service��ѯ��ҳ����,Ҳ����PageBean
		PageBean pageBean = customerService.getPageBean(detachedCriteria,currentPage,pageSize);
		//��PageBean����request������,��ת���б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	public String add() throws Exception {
		//���ϴ��ļ��ϴ���ָ��λ��
		if (photo != null) {
			
		photo.renameTo(new File("E:/study/"+photoFileName+".png"));
		}
		
		//����service����Customer����
		customerService.save(customer);
		//�ض��򵽿ͻ��б�Action
		return "toList";
	}
	
	public String industryCount() throws Exception {
		List<Object[]> list = customerService.getIndustryCount();
		ActionContext.getContext().put("list", list);
		return "industryCount";
	}
	
	public String toEdit() throws Exception {
		//1����Service����id��ÿͻ�����
		if (customer.getCust_id() != null) {
			
		Customer c = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		return "edit";
		
		}
	//2 ���ͻ�������õ�request��,��ת�����༭ҳ��
	    return null;
	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	
}
