<%--
  User: zhangteng
  Date: 13-12-7 下午2:09
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>文章列表</title>
    <link rel="stylesheet" href="${staticWebsite}assets/css/ace.min.css" />
</head>
<body>
<div class="table-responsive">
    <div class="row">
        <form action="${website}archive/tableList" method="get">
        <div class="col-sm-6">
            <div id="sample-table-2_length" class="dataTables_length">
                <label>Display
                    <select name="pageSize" size="1" aria-controls="sample-table-2">
                    <option value="10" selected="selected">10</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select> records</label>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="dataTables_filter" id="sample-table-2_filter">
                <label>Search:
                    <input name="search" type="text" aria-controls="sample-table-2">
                </label>
                <span class="form-inline">
                    <button id="search-btn" style="border-radius:0;" type="button" class="btn btn-info btn-sm">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </span>
            </div>
        </div>
        </form>
    </div>
    <table id="sample-table-2" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="center">
                <label>
                    <input type="checkbox" class="ace" />
                    <span class="lbl"></span>
                </label>
            </th>
            <th>Title</th>
            <th>createTime</th>
            <th>
                <i class="icon-time bigger-110 hidden-480"></i>
                viewCount
            </th>
            <th class="hidden-480">Status</th>

            <th></th>
        </tr>
        </thead>

        <tbody id="archive-tbody">
            <c:if test="${empty archiveList}">
            <tr id="nothing">
                <td colspan="7" style="text-align: center">
                暂无数据！
                </td>
            </tr>
            </c:if>
            <c:forEach var = "archive" items="${archiveList}">
                <tr>
                    <td class="center">
                        <label>
                        <input type="checkbox" class="ace" />
                        <span class="lbl"></span>
                        </label>
                    </td>
                    <td>
                        <a href="${website}archive/${archive.id}" target="_blank">${archive.title}</a>
                    </td>
                    <td>${archive.createTimeStr}</td>
                    <td>${archive.viewCount}</td>

                    <td class="hidden-480">
                        <span class="label label-sm label-warning">${archive.status}</span>
                    </td>

                    <td>
                        <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                            <a class="blue" href="${website}archive/${archive.id}" target="_blank">
                                <i class="icon-zoom-in bigger-130"></i>
                            </a>

                            <a class="green" href="${website}archive/update/${archive.id}" data-trigger="ajax" data-target="#ajax_target">
                                <i class="icon-pencil bigger-130"></i>
                            </a>

                            <a class="red" href="${website}archive/delete/${archive.id}" data-trigger="ajax" data-target="#ajax_target">
                                <i class="icon-trash bigger-130"></i>
                            </a>
                        </div>

                        <div class="visible-xs visible-sm hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
                                    <i class="icon-caret-down icon-only bigger-120"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="${website}archive/${archive.id}" class="tooltip-info" data-rel="tooltip" title="View" data-trigger="ajax" data-target="#ajax_target">
            <span class="blue">
            <i class="icon-zoom-in bigger-120"></i>
            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="${website}archive/update/${archive.id}" class="tooltip-success" data-rel="tooltip" title="Edit" data-trigger="ajax" data-target="#ajax_target">
            <span class="green">
            <i class="icon-edit bigger-120"></i>
            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="${website}archive/delete/${archive.id}" class="tooltip-error" data-rel="tooltip" title="Delete" data-trigger="ajax" data-target="#ajax_target">
            <span class="red">
            <i class="icon-trash bigger-120"></i>
            </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="row">
    <div class="col-sm-6">
        <div class="dataTables_paginate paging_bootstrap">
            <ul class="pagination">
                <li class="prev">
                    <a data-trigger="ajax" data-target="#ajax_target" href="${website}archive/tableList?search=${search}&pageNo=${page.prevPage}">
                        <i class="icon-double-angle-left"></i>
                    </a>
                </li>
                <c:forEach var="pageNo" items="${page.pageList}">
                    <c:choose>
                        <c:when test="${pageNo == page.currentPage}">
                            <li class="active"><a href="#">${pageNo}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a data-trigger="ajax" data-target="#ajax_target" href="${website}archive/tableList?search=${search}&pageNo=${pageNo}">${pageNo}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li class="next">
                    <a data-trigger="ajax" data-target="#ajax_target" href="${website}archive/tableList?search=${search}&pageNo=${page.nextPage}">
                        <i class="icon-double-angle-right"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="${staticWebsite}assets/js/jquery.form.min.js"></script>
<script>
    $('#search-btn').on('click', function(){
        $('form').ajaxSubmit({
            target: '#ajax_target'
        });
    });
</script>
</body>
</html>