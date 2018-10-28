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
		
		//��װ���߲�ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		System.out.println("����"+user.getUser_name());
		//�жϲ���װ����
		if (StringUtils.isNotBlank(user.getUser_name())) {
			detachedCriteria.add(Restrictions.like("user_name", "%"+user.getUser_name()+"%"));
					
		}
		
		
		
		//����Service��ѯ��ҳ����,Ҳ����PageBean
		PageBean pageBean = userService.getPageBean(detachedCriteria,currentPage,pageSize);
		//��PageBean����request������,��ת���б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "list";
	}
	
	
	
	public String add() throws Exception {
		
		
		//����service����Customer����
		userService.save(user);
		//�ض��򵽿ͻ��б�Action
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1����Service����id��ÿͻ�����
		if (user.getUser_id() != null) {
			
		User u = userService.getById(user.getUser_id());
		ActionContext.getContext().put("user", u);
		return "edit";
		
		}
	//2 ���ͻ�������õ�request��,��ת�����༭ҳ��
	    return null;
	}
	
	public String login() throws Exception {
			//1 ����Serviceִ�е�½�߼�
		
			User u = userService.getUserByCodePassword(user);
			//2 �����ص�User�������session��
			ActionContext.getContext().getSession().put("user", u);
			//3 �ض�����Ŀ��ҳ
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

