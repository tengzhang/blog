<%--
  User: zhangteng
  Date: 13-12-6 下午4:22
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../index/common/head.jsp" />
    <title>文章正文</title>
    <link href="${staticWebsite}index/css/article.css" rel="stylesheet" media="screen">
    <!-- For syntax highlighting -->
    <link rel="stylesheet" href="${staticWebsite}assets/css/highlight/monokai.css">
</head>
<body>

<jsp:include page="../index/common/navbar.jsp" />
<div class="jumbotron" id="header">
    <div class="container">
        <div class="pull-left"><h1>Archives</h1></div>
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

<div class="jumbotron" id="content">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h2>
                    <i class="glyphicon glyphicon-hand-right"></i> ${archive.title}
                    <small> post on [<fmt:formatDate value="${archive.createTime}" pattern="yyyy-MM-dd" />]</small></h2>
                <div id="contents">
                    <textarea id="markdown-editor" name="content" rows="10">
${archive.content}
                    </textarea>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
<!-- Duoshuo Comment BEGIN -->
<div class="ds-thread"></div>
</div>
<script type="text/javascript">
    var duoshuoQuery = {short_name:"zhangteng"};
    (function() {
        var ds = document.createElement('script');
        ds.type = 'text/javascript';ds.async = true;
        ds.src = 'http://static.duoshuo.com/embed.js';
        ds.charset = 'UTF-8';
        (document.getElementsByTagName('head')[0]
                || document.getElementsByTagName('body')[0]).appendChild(ds);
    })();
</script>
<!-- Duoshuo Comment END -->


<jsp:include page="../index/common/footer.jsp" />
<jsp:include page="../index/common/script.jsp" />
<script type="text/javascript" src="${staticWebsite}assets/js/highlight.pack.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/bootstrap-markdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/markdown.js"></script>
<script>
    $(function(){
        $('#markdown-editor').markdown({
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