<%--
  User: zhangteng
  Date: 13-12-10 下午3:12
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员列表</title>
    <link rel="stylesheet" href="${staticWebsite}assets/css/ace.min.css" />
</head>
<body>
<div class="table-responsive">
    <table id="sample-table-2" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="center">
                <label>
                    <input type="checkbox" class="ace" />
                    <span class="lbl"></span>
                </label>
            </th>
            <th>adminName</th>
            <th>createTime</th>
            <th class="hidden-480">Status</th>

            <th></th>
        </tr>
        </thead>

        <tbody id="archive-tbody">

            <c:if test="${empty adminList}">
            <tr id="nothing">
                <td colspan="7" style="text-align: center">
                    暂无数据！
                </td>
            </tr>
            </c:if>
            <c:forEach var="admin" items="${adminList}">
            <tr>
                <td class="center">
                    <label>
                        <input type="checkbox" class="ace" />
                        <span class="lbl"></span>
                    </label>
                </td>

                <td>
                    <a href="#">${admin.name}</a>
                </td>
                <td>${admin.createTime}</td>
                <td class="hidden-480">${admin.status}</td>
                <td>
                    <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">

                        <a data-trigger="ajax" data-target="#ajax_target" class="green" href="${website}admin/update/${admin.id}">
                            <i class="icon-pencil bigger-130"></i>
                        </a>

                        <a data-trigger="ajax" data-target="#ajax_target" class="red" href="${website}admin/delete/${admin.id}">
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
                                    <a data-trigger="ajax" data-target="#ajax_target" href="${website}admin/update/${admin.id}" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                                    <span class="green">
                                                                                        <i class="icon-edit bigger-120"></i>
                                                                                    </span>
                                    </a>
                                </li>

                                <li>
                                    <a data-trigger="ajax" data-target="#ajax_target" href="${website}admin/delete/${admin.id}" class="tooltip-error" data-rel="tooltip" title="Delete">
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
        <div class="dataTables_info" id="sample-table-2_info">Showing 11 to 20 of 23 entries</div>
    </div>
    <div class="col-sm-6">
        <div class="dataTables_paginate paging_bootstrap">
            <ul class="pagination">
                <li class="prev"><a href="#"><i class="icon-double-angle-left"></i></a></li>
                <li><a href="#">1</a></li>
                <li class="active"><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="next"><a href="#"><i class="icon-double-angle-right"></i></a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>