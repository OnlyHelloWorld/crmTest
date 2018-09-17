package com.star.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.SaleVisit;
import com.star.domain.User;
import com.star.service.ISaleVisitService;
import com.star.utils.PageBean;

public class SaleVisitAction  extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit = new SaleVisit();
	
	private ISaleVisitService SaleVisitService ;
	
	//添加客户拜访记录
	public String add() throws Exception {
		//0 取出登陆用户,放入SaleVisit实体.表达关系
			User u = (User) ActionContext.getContext().getSession().get("user");
			saleVisit.setUser(u);
			System.out.println(saleVisit);
			System.out.println(u);
		//1 调用Service保存客户拜访记录
			SaleVisitService.save(saleVisit);
		//2 重定向到拜访记录列表Action
		return "toList";
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = SaleVisitService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}


	//去往编辑页面回显
	public String toEdit() throws Exception {
			//1 调用Service根据id查询客户拜访对象
			SaleVisit sv = SaleVisitService.getById(saleVisit.getVisit_id());
			//2 将对象放入request域
			ActionContext.getContext().put("saleVisit", sv);
			//3 转发到add.jsp
			return "add";
	}

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}

	public void setSaleVisitService(ISaleVisitService SaleVisitService) {
		this.SaleVisitService = SaleVisitService;
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

