package com.star.web.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.Supplier;
import com.star.domain.User;
import com.star.service.IUserService;
import com.star.utils.PageBean;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	private IUserService userService ;
	

	private Integer currentPage;
	private Integer pageSize;
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String list() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		
		if (u.getUser_role() == 2 ) {
			return "noPermission";
		}
		
		//封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		System.out.println("测试"+user.getUser_name());
		//判断并封装参数
		if (StringUtils.isNotBlank(user.getUser_name())) {
			detachedCriteria.add(Restrictions.like("user_name", "%"+user.getUser_name()+"%"));
					
		}
		
		
		
		//调用Service查询分页数据,也就是PageBean
		PageBean pageBean = userService.getPageBean(detachedCriteria,currentPage,pageSize);
		//将PageBean放入request作用域,并转到列表页面显示
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	
	
	public String add() throws Exception {
		
		
		//调用service保存Customer对象
		userService.save(user);
		//重定向到客户列表Action
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1调用Service根据id获得客户对象
		if (user.getUser_id() != null) {
			
		User u = userService.getById(user.getUser_id());
		ActionContext.getContext().put("user", u);
		return "edit";
		
		}
	//2 将客户对象放置到request域,并转发到编辑页面
	    return null;
	}
	
	public String login() throws Exception {
			//1 调用Service执行登陆逻辑
		
			User u = userService.getUserByCodePassword(user);
			//2 将返回的User对象放入session域
			ActionContext.getContext().getSession().put("user", u);
			//3 重定向到项目首页
		return "toHome";
	}
	public String regist() throws Exception {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "toLogin";
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

	@Override
	public User getModel() {
		return user;
	}

}

