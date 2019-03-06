<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" href="/css/font-awesome-4.7.0/css/font-awesome.min.css">
<%--<link rel="stylesheet" href="/js/bootstrap-3.3.4-dist/css/bootstrap.min.css">--%>

<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/shopcar.js"></script>
<script type="text/javascript" src="js/template.js"></script>
<!--字体图标-->
<link href="/lib/javaex/pc/css/icomoon.css" rel="stylesheet" />
<!--动画-->
<link href="/lib/javaex/pc/css/animate.css" rel="stylesheet" />
<!--骨架样式-->
<link href="/lib/javaex/pc/css/common.css" rel="stylesheet" />
<!--皮肤（缇娜）-->
<link href="/lib/javaex/pc/css/skin/tina.css" rel="stylesheet" />
<!--jquery，不可修改版本-->
<script src="/lib/javaex/pc/lib/jquery-1.7.2.min.js"></script>
<!--全局动态修改-->
<script src="/lib/javaex/pc/js/common.js"></script>
<!--核心组件-->
<script src="/lib/javaex/pc/js/javaex.min.js"></script>
<!--表单验证-->
<script src="/lib/javaex/pc/js/javaex-formVerify.js"></script>
<script type="text/javascript">
	 //用于用户中心左边菜单栏的选择项的样式
	function setSelectedClass(url){
		 $('div.cont ul.list li a[href~="'+url+'"]').parent().addClass("current");
	} 
</script>