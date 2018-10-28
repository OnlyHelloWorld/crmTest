<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#saleOrder==null?'添加':'修改'" />订单记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<!-- 使用日期控件步骤1: 导入js和css -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
	
<!-- 使用日期控件步骤2: 当页面加载完成时,调用 datepick方法指定需要应用的文本框 -->
	$(document).ready(function(){
			// yy 已经代表了4位的年份
			// mm 代表月份
			// dd 代表日期
		$('#order_time').datepick({dateFormat: 'yy-mm-dd'}); 
		$('#order_nexttime').datepick({dateFormat: 'yy-mm-dd'}); 
	});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/SaleOrderAction_add"
		method="post"  onsubmit="return checkForm(['user.user_id','Order_nexttime']);" >
		<!-- 隐藏域回显当前编辑的拜访记录id -->
		<input  type="hidden"  name="order_id" value="<s:property value="#saleOrder.order_id" />"  />

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：订单记录管理 &gt; <s:property value="#saleOrder==null?'添加':'修改'" />订单记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>所属供应商：</td>
								<td >
								<input type="hidden" name="order_supplier_id.supplier_id" style="WIDTH: 180px" id="supplier_id" value="<s:property value="#saleOrder.order_supplier_id.supplier_id" />" />
								<input type="text"  style="WIDTH: 180px" id="supplier_name" value="<s:property value="#saleOrder.order_supplier_id.supplier_name" />"/>
									<input type="button" value="选择客户" onclick="window.open('${pageContext.request.contextPath}/SupplierAction_list?select=true','','width=600,height=300')" />
								
								</td>
								<td>下单时间 ：</td>
								<td  >
									<INPUT class=textbox id="order_time" type="text" 
														style="WIDTH: 180px" maxLength=50 name="order_time" readonly="readonly" value="<s:property value="#saleOrder.order_time_s" />" >
								</td>
							</TR>
							
							<TR>
								
								<td>供应商负责人 ：</td>
								<td >
								<INPUT class=textbox id=sChannel2 type="text"
														style="WIDTH: 180px" maxLength=50 name="order_interviewee" value="<s:property value="#saleOrder.order_interviewee" />" >
								</td>
								<td>下单地址：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="order_addr" value="<s:property value="#saleOrder.order_addr" />">
								</td>
							</TR>
							
							<TR>
								
								
								<td>订单详情 ：</td>
								<td>
								<INPUT class=textbox id="supplier_phone"
														style="WIDTH: 180px" maxLength=50 name="order_detail" value="<s:property value="#saleOrder.order_detail" />">
								</td>
								<td>下次下单时间：</td>
								<td>
								<INPUT class=textbox id="order_nexttime" readonly="readonly"
														style="WIDTH: 180px" maxLength=50 name="order_nexttime" value="<s:property value="#saleOrder.order_nexttime_s" />">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type="submit"
														value="保存 " name=sButton2>
								</td>
							</tr>
							
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
