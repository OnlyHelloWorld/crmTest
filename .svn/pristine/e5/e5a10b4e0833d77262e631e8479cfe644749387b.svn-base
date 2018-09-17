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
	//为文件上传做准备,准备结束,搞定
	private File photo;
	private String photoFileName;
	
	private Integer currentPage;
	private Integer pageSize;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
					
		}
		//调用Service查询分页数据,也就是PageBean
		PageBean pageBean = customerService.getPageBean(detachedCriteria,currentPage,pageSize);
		//将PageBean放入request作用域,并转到列表页面显示
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	public String add() throws Exception {
		//将上传文件上传到指定位置
		if (photo != null) {
			
		photo.renameTo(new File("E:/study/"+photoFileName+".png"));
		}
		
		//调用service保存Customer对象
		customerService.save(customer);
		//重定向到客户列表Action
		return "toList";
	}
	
	public String industryCount() throws Exception {
		List<Object[]> list = customerService.getIndustryCount();
		ActionContext.getContext().put("list", list);
		return "industryCount";
	}
	
	public String toEdit() throws Exception {
		//1调用Service根据id获得客户对象
		if (customer.getCust_id() != null) {
			
		Customer c = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		return "edit";
		
		}
	//2 将客户对象放置到request域,并转发到编辑页面
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
