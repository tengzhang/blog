<%--
  User: zhangteng
  Date: 13-12-12 下午5:45
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>查看更多</title>
    <link href="${staticWebsite}index/css/content.css" rel="stylesheet" media="screen">
    <link href="${staticWebsite}assets/css/font-awesome.min.css" rel="stylesheet" media="screen">
</head>
<body>
<%-- navbar start --%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="${website}">BLOG</a>
    </div>
    <div id="mynav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li>
                <a href="${website}">Home</a>
            </li>
            <li class="active">
                <a href="${website}archive/list">Archives</a>
            </li>
            <li>
                <a href="${website}about">About us</a>
            </li>
        </ul>

        <div class="pull-right" id="search" style="position: absolute;top: 10px; right: 0px;">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control" style="border-radius:0;" placeholder="search...">
				    <span class="input-group-btn">
						<button class="btn btn-default" type="button" style="border-radius:0;">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
		            </span>
            </div>
        </div>
    </div>
</nav>
<%-- navbar end --%>

<div class="jumbotron" id="header">
    <div class="container">
        <div class="pull-left"><h1>Content of archives</h1></div>
        <div class="pull-right">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${website}">Home</a>
                </li>
                <li>
                    <a href="${website}archive/list">Archives</a>
                </li>
                <li>
                    <a href="${website}about">About us</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container" id="content">
        <c:forEach var="archive" items="${archiveList}">
        <div class="row">
            <div class="col-sm-12">
                <h3>
                    <i class="glyphicon glyphicon-hand-right"></i>
                    <a href="${website}archive/${archive.id}">${archive.title}</a>
                    <small> post on [<fmt:formatDate value="${archive.createTime}" pattern="yyyy-MM-dd" /> ]</small>
                </h3>
            </div>
        </div>
        </c:forEach>
    </div>
    <div id="show_more_container" class="container" style="display: none">
        <div class="row" id="show_more">
            <div class="col-sm-12">
                <i class="icon-spinner icon-spin"></i>
                加载更多
            </div>
        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp" />
<jsp:include page="common/script.jsp" />
<script type="text/javascript" src="${staticWebsite}assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${staticWebsite}js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="${staticWebsite}js/showMore.js"></script>

</body>
</html>