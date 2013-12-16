<%--
  User: zhangteng
  Date: 13-12-12 下午5:48
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
