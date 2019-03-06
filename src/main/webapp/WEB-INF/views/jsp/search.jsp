<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="searchbar">
	<div class="allsort">
		<i class="fa fa-briefcase fa-2x"></i><a class="navbar-link dropdown-toggle" href="javascript:void(0);">全部商品分类</a>

		<!--总的商品分类-开始-->
		<ul class="sortlist" id="div_allsort" style='display: none'>
			<c:forEach items="${categories}" var="category">
				<li>
					<h2>
						<%--<a href="./goods/listByCate?goodsCategoryId=${category.id}">${category.name}</a>--%>
						<a href="./goods/listByPageCate?categoryId=${category.id}&order=sellnum">${category.name}</a>
					</h2>
				</li>
			</c:forEach>
		</ul>
	</div>
    <div class="searchbox">
		<form method='get' action='./goods/search'>
			<input type='hidden' name='controller' value='site' />
			<input type='hidden' name='action' value='search_list' />
            <i class="fa fa-search fa-2x" style="margin-top:4px;"></i>
                <c:choose>
                <c:when test="${word ne null}">
                    <input class="text"  type="text" name='word' autocomplete="off"
		    				   placeholder="${word}" />
                </c:when>
                <c:otherwise>
                    <input class="text"  type="text" name='word' autocomplete="off"
                                placeholder="输入关键字..." />
                </c:otherwise>
            </c:choose>
                <input class="btn bg-success" type="submit" value="商品搜索"
                       onclick="checkInput('word','输入关键字...');" />

		</form>
    </div>
	<%--<div class="hotwords">热门搜索：</div>--%>

<script>
	$(function() {
		$(".allsort").hover(function() {
			$('#div_allsort').show();
		}, function() {
			$('#div_allsort').hide();
		});
	});
</script>

<%--输入框美化--%>
    <%--<script>--%>
        <%--$("#put1").focus(function() {--%>
            <%--$(this).parent("searchbox").addClass("active");--%>
        <%--});--%>
        <%--$("#put1").blur(function() {--%>
            <%--if ($(this).val() == "") {--%>
                <%--$(this).parent("searchbox").removeClass("active");--%>
            <%--}--%>
        <%--})--%>
        <%--$("#put2").focus(function() {--%>
            <%--$(this).parent("searchbox").addClass("active");--%>
        <%--});--%>
        <%--$("#put2").blur(function() {--%>
            <%--if ($(this).val() == "") {--%>
                <%--$(this).parent("searchbox").removeClass("active");--%>
            <%--}--%>
        <%--})--%>
    <%--</script>--%>