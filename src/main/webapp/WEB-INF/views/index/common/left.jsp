<%--
  User: zhangteng
  Date: 13-12-6 下午4:46
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!--左边导航开始-->
<div class="col-sm-2">
    <div class="navbar-wrapper stuckMenu navbar-static-top" style="position: fixed; top: 0px;">
        <div class="navbar navbar-inverse" style="border-radius:0;">
            <div class="container">
                <div class="navbar-header">
                    <!--网页的logo或者是作者的照片-->
                    <a href="#">
                        <img src="${staticWebsite}index/images/thumb-6.jpg" class="img-responsive" alt="Responsive image" >Blog Of zT & Cy
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <!--左边导航菜单开始-->
                    <ul class="list-unstyled nav navbar-nav">
                        <li class="menuItem" id="${website}"><a href="">Home</a></li>
                        <li class="menuItem"><a href="${website}archive">Archives</a></li>
                        <li class="menuItem"><a href="${website}about">About us</a></li>
                    </ul>
                    <!--左边导航菜单结束-->
                </div>
            </div>
        </div>
    </div>
</div>
<!--左边导航结束-->