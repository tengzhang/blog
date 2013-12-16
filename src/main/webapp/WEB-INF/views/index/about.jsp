<%--
  User: zhangteng
  Date: 13-12-10 上午11:16
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>关于我们</title>
    <link href="${website}index/css/aboutUs.css" rel="stylesheet" media="screen">
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
            <li>
                <a href="${website}archive/list">Archives</a>
            </li>
            <li class="active">
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
        <div class="pull-left"><h1>About us</h1></div>
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

<div class="jumbotron" id="content">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h2><i class="glyphicon glyphicon-hand-right"></i> Who am I?<small> post on [12-12]</small></h2>
                <p>我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁</p>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron" id="comment">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h2><i class="glyphicon glyphicon-hand-right"></i> Comment<small> post on [12-12]</small></h2>
                <p>我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁我是谁</p>
            </div>
        </div>
    </div>
</div>


<div class="share">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
                <i class="glyphicon glyphicon-star"></i>
            </div>
        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp" />
<jsp:include page="common/script.jsp" />

</body>
</html>