package com.star.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.LinkMan;
import com.star.domain.User;
import com.star.service.ILinkManService;
import com.star.utils.PageBean;
import com.star.utils.RequiredPermission;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

private LinkMan linkMan = new LinkMan();
	
	private ILinkManService linkManService;

	private Integer currentPage;
	private Integer pageSize;
	
	
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//�жϲ���װ����
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getSupplier()!=null&&linkMan.getSupplier().getSupplier_id()!=null){
			dc.add(Restrictions.eq("supplier.supplier_id", linkMan.getSupplier().getSupplier_id()));
		}
		
		
		//1 ����Service��ѯ��ҳ����(PageBean)
		PageBean pb = linkManService.getPageBean(dc,currentPage,pageSize);
		//2 ��PageBean����request��,ת�����б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String delete() throws Exception{
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		System.out.println("������ID"+linkMan.getLkm_id());
		linkManService.deleteItem(linkMan.getLkm_id());
		return "toList";
	}
	
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		//1 ����Service
		linkManService.save(linkMan);
		//2 �ض�����ϵ���б�(404)
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1 ����Service,��ѯLinkMan
		LinkMan lm = linkManService.getById(linkMan.getLkm_id());
		//2 ����ѯ��Linkman�������request��,ת�������ҳ��
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}


	@Override
	public LinkMan getModel() {
		return linkMan;
	}


	public void setlinkManService(ILinkManService linkManService) {
		this.linkManService = linkManService;
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
	

}
