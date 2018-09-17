package com.star.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.star.domain.User;
import com.star.service.IUserService;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	private IUserService userService ;
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
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

	@Override
	public User getModel() {
		return user;
	}

}

