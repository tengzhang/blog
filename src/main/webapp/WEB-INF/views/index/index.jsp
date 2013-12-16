<%--
  User: zhangteng
  Date: 13-12-5 下午3:13
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>博客首页</title>
    <link href="${staticWebsite}index/css/blogIndex.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="${staticWebsite}assets/css/highlight/monokai.css">
</head>
<body>
<%-- navbar start --%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="${website}">BLOG</a>
    </div>
    <div id="mynav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active">
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
            <form action="${website}archive/list" method="get">
            <div class="input-group input-group-sm">
                <input name="search" type="text" class="form-control" style="border-radius:0;" placeholder="search...">
				    <span class="input-group-btn">
						<button id="search-btn"  class="btn btn-default" type="submit" style="border-radius:0;">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
		            </span>
            </div>
            </form>
        </div>
    </div>
</nav>
<%-- navbar end --%>

<div class="jumbotron" id="header">
    <div class="container">
        <div class="pull-left"><h1>I'm ZhangTeng!</h1></div>
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

<div class="jumbotron" id="someArticles">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="icon-feature">
                    <i class="glyphicon glyphicon-resize-full"></i>
                </div>
                <h3>${archive1.title}</h3>
                <textarea name="markdown-editor">${archive1.content}</textarea>
                <a href="${website}archive/${archive1.id}" class="pull-right">more >>></a>
            </div>
            <div class="col-sm-4">
                <div class="icon-feature">
                    <i class="glyphicon glyphicon-cog"></i>
                </div>
                <h3>${archive2.title}</h3>
                <textarea name="markdown-editor">${archive2.content}</textarea>
                <a href="${website}archive/${archive2.id}" class="pull-right">more >>></a>
            </div>
            <div class="col-sm-4">
                <div class="icon-feature">
                    <i class="glyphicon glyphicon-glass"></i>
                </div>
                <h3>${archive3.title}</h3>
                <textarea name="markdown-editor">${archive3.content}</textarea>
                <a href="${website}archive/${archive3.id}" class="pull-right">more >>></a>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron getArticles">
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <p><h3>点击按钮可查看更多文章</h3></p>
            </div>
            <div class="col-sm-3">
                <a class="btn btn-default btn-lg" href="${website}archive/list">
                    猛戳这里 >>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row" id="otherArticles">
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-bookmark"></i>
                ${archive4.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive4.content}</textarea>
            <a href="${website}archive/${archive4.id}" class="pull-right">more >>></a>
        </div>
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-music"></i>
                ${archive5.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive5.content}</textarea>
            <a href="${website}archive/${archive5.id}" class="pull-right">more >>></a>
        </div>
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-hand-right"></i>
                ${archive6.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive6.content}</textarea>
            <a href="${website}archive/${archive5.id}" class="pull-right">more >>></a>
        </div>
    </div>

    <div class="row" id="otherArticles_1">
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-file" style="color:#DD4B37;"></i>
                ${archive7.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive7.content}</textarea>
            <a href="${website}archive/${archive7.id}" class="pull-right">more >>></a>
        </div>
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-folder-close" style="color:#78BA37;"></i>
                ${archive8.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive8.content}</textarea>
            <a href="${website}archive/${archive8.id}" class="pull-right">more >>></a>
        </div>
        <div class="col-sm-4">
            <h4>
                <i class="glyphicon glyphicon-font" style="color:#BA55DB;"></i>
                ${archive9.title}
            </h4>
            <p></p>
            <textarea name="markdown-editor">${archive9.content}</textarea>
            <a href="${website}archive/${archive9.id}" class="pull-right">more >>></a>
        </div>
    </div>
</div>

<div class="jumbotron getArticles">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h2 style="text-align:center;font-size:26px;"><p>About us</p></h2>
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
<script type="text/javascript" src="${staticWebsite}assets/js/highlight.pack.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/bootstrap-markdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/markdown.js"></script>
<script>
    $(function(){
        $('[name="markdown-editor"]').markdown({
            onShow: function(e) {
                e.showPreview();
                e.hideButtons();
            }
        });
        hljs.tabReplace = '    '; // 4 spaces
        hljs.initHighlightingOnLoad();
        $('pre code').each(function(i, e) {hljs.highlightBlock(e)});

    });
</script>
</body>
</html>