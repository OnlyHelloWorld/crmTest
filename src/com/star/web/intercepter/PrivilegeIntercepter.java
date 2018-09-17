package com.star.web.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.star.domain.User;

public class PrivilegeIntercepter extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获取登录标识(也就是user对象),判断是否存在
		User user = (User) session.get("user");
		//如果判断存在说明已经登录,放行;如果不存在,拦截,会登录页面
		if (user != null) {
			return invocation.invoke();
		}else {
			return "toLogin";
			
		}
	}

}
