<%--
  User: zhangteng
  Date: 13-12-6 下午3:18
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加文章</title>
    <link rel="stylesheet" href="${staticWebsite}assets/css/bootstrap-markdown.min.css">

    <!-- For syntax highlighting -->
    <link rel="stylesheet" href="${staticWebsite}assets/css/highlight/monokai.css">
</head>
<body>
<div class="container">
    <form action="${website}archive/insert" method="post">
        <input class="form-control" name="title" type="text" placeholder="Title?" />
        <textarea id="markdown-editor" name="content" rows="10"></textarea>
        <hr/>
        <button id="archive-save" type="button" class="btn btn-sm btn-primary">保存</button>
    </form>
</div>
<script type="text/javascript" src="${staticWebsite}assets/js/highlight.pack.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/bootstrap-markdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/markdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/to-markdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/myMarkdown.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/jquery.form.min.js"></script>
<script>
    $(function(){

        $('#markdown-editor').markdown({
        });
        hljs.tabReplace = '    '; // 4 spaces
        hljs.initHighlightingOnLoad();
        $('pre code').each(function(i, e) {hljs.highlightBlock(e)});

        $('#archive-save').on('click', function(){
            $('form').ajaxSubmit({
                target: '#ajax_target'
            });
        });
    });
</script>
</body>
</html>