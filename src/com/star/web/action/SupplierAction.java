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
	//Ϊ�ļ��ϴ���׼��,׼������,�㶨
	private File photo;
	private String photoFileName;
	
	private Integer currentPage;
	private Integer pageSize;
	

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Supplier.class);
		System.out.println("����"+supplier.getSupplier_name());
		//�жϲ���װ����
		if (StringUtils.isNotBlank(supplier.getSupplier_name())) {
			detachedCriteria.add(Restrictions.like("supplier_name", "%"+supplier.getSupplier_name()+"%"));
					
		}
		//����Service��ѯ��ҳ����,Ҳ����PageBean
		PageBean pageBean = supplierService.getPageBean(detachedCriteria,currentPage,pageSize);
		//��PageBean����request������,��ת���б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	public String delete() throws Exception{
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		System.out.println("��Ӧ��ID"+supplier.getSupplier_id());
		supplierService.deleteItem(supplier.getSupplier_id());
		return "toList";
	}
	
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		//���ϴ��ļ��ϴ���ָ��λ��
		if (photo != null) {
			
		photo.renameTo(new File("E:/study/"+photoFileName+".png"));
		}
		
		//����service����Customer����
		supplierService.save(supplier);
		//�ض��򵽿ͻ��б�Action
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1����Service����id��ÿͻ�����
		if (supplier.getSupplier_id() != null) {
			
		Supplier s = supplierService.getById(supplier.getSupplier_id());
		ActionContext.getContext().put("supplier", s);
		return "edit";
		
		}
	//2 ���ͻ�������õ�request��,��ת�����༭ҳ��
	    return null;
	}
	
	//��ҵͳ��
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
