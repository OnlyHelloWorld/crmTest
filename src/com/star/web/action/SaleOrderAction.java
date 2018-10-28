package com.star.web.action;

import javax.persistence.criteria.Order;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.SaleOrder;
import com.star.domain.User;
import com.star.service.ISaleOrderService;
import com.star.utils.PageBean;

public class SaleOrderAction  extends ActionSupport implements ModelDriven<SaleOrder>{
	private SaleOrder saleOrder = new SaleOrder();
	
	private ISaleOrderService SaleOrderService ;
	
	public String add() throws Exception {
			User u = (User) ActionContext.getContext().getSession().get("user");
			if (u.getUser_role() == 2) {
				return "noPermission";
			}
			saleOrder.setOrder_user_id(u);
			System.out.println(saleOrder);
			System.out.println(saleOrder.getOrder_supplier_id());
			System.out.println("”√ªß"+u);
			SaleOrderService.save(saleOrder);
		return "toList";
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(SaleOrder.class);
		if(saleOrder.getOrder_supplier_id()!=null &&saleOrder.getOrder_supplier_id().getSupplier_id()!=null){
			dc.add(Restrictions.eq("order_supplier_id.supplier_id",saleOrder.getOrder_supplier_id().getSupplier_id()));
		}
		
		PageBean pb = SaleOrderService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}


	public String delete() throws Exception{
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2) {
			return "noPermission";
		}
		SaleOrderService.deleteItem(saleOrder.getOrder_id());
		return "toList";
	}
	
	public String toEdit() throws Exception {
			SaleOrder so = SaleOrderService.getById(saleOrder.getOrder_id());
			ActionContext.getContext().put("saleOrder", so);
			return "add";
	}

	@Override
	public SaleOrder getModel() {
		return saleOrder;
	}

	public void setSaleOrderService(ISaleOrderService saleOrderService) {
		SaleOrderService = saleOrderService;
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

