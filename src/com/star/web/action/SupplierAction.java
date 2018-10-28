package com.star.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.Supplier;
import com.star.domain.User;
import com.star.service.ISupplierService;
import com.star.utils.PageBean;
import com.sun.org.apache.regexp.internal.recompile;

public class SupplierAction extends ActionSupport implements ModelDriven<Supplier>{

	private Supplier supplier = new Supplier();
	
	private ISupplierService supplierService;
	//为文件上传做准备,准备结束,搞定
	private File photo;
	private String photoFileName;
	
	private Integer currentPage;
	private Integer pageSize;
	

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Supplier.class);
		System.out.println("测试"+supplier.getSupplier_name());
		//判断并封装参数
		if (StringUtils.isNotBlank(supplier.getSupplier_name())) {
			detachedCriteria.add(Restrictions.like("supplier_name", "%"+supplier.getSupplier_name()+"%"));
					
		}
		//调用Service查询分页数据,也就是PageBean
		PageBean pageBean = supplierService.getPageBean(detachedCriteria,currentPage,pageSize);
		//将PageBean放入request作用域,并转到列表页面显示
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	public String delete() throws Exception{
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		System.out.println("供应商ID"+supplier.getSupplier_id());
		supplierService.deleteItem(supplier.getSupplier_id());
		return "toList";
	}
	
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		//将上传文件上传到指定位置
		if (photo != null) {
			
		photo.renameTo(new File("E:/study/"+photoFileName+".png"));
		}
		
		//调用service保存Customer对象
		supplierService.save(supplier);
		//重定向到客户列表Action
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1调用Service根据id获得客户对象
		if (supplier.getSupplier_id() != null) {
			
		Supplier s = supplierService.getById(supplier.getSupplier_id());
		ActionContext.getContext().put("supplier", s);
		return "edit";
		
		}
	//2 将客户对象放置到request域,并转发到编辑页面
	    return null;
	}
	
	//行业统计
	public String industryCount() throws Exception {
		
		List<Object[]> list = supplierService.getIndustryCount();
		
		ActionContext.getContext().put("list", list);
		
		return "industryCount";
		
		}

	@Override
	public Supplier getModel() {
		// TODO Auto-generated method stub
		return supplier;
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
