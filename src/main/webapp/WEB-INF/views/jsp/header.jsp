<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<h1 class="logo">
		<a title="" style="background: url(#);" href="">电子商务平台</a>
	</h1>
	<ul class="shortcut">
		<li class="first"><a href="./order/uindex"><i class="fa fa-home fa-2x"></i>会员中心</a></li>

		<li><a href="./order/listByUser"><i class="fa fa-cart-arrow-down fa-2x"></i>我的订单</a></li>


        <c:if test="${sessionScope.user.role eq 'a'}">
			<li><a href="./user/toAdminLogin"><i class="fa fa-gear fa-2x"></i>后台管理</a></li>

		</c:if>
		<li class='last'><a href=""><i class="fa fa-book fa-2x"></i>使用帮助</a></li>
	</ul>
	<p class="loginfo">
        <!-- 判断当前用户登录状态-显示不同选项-->
		<c:if test="${not empty sessionScope.user}">
			<i class="fa fa-user fa-2x"></i>${user.name}您好，欢迎来到${site}！[<a href="./user/logout" class="reg"><i class="fa fa-sign-out fa-2x"></i>安全退出</a>]
	  </c:if>
		<c:if test="${empty sessionScope.user}">
			[<a href="./user/toLogin"><i class="fa fa-user-circle-o fa-2x"></i>登录</a>
			<a class="reg" href="./user/toRegister"><i class="fa fa-sign-in fa-2x"></i>免费注册</a>]
	  </c:if>
	</p>
</div>