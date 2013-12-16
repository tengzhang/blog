<%--
  User: zhangteng
  Date: 13-12-11 上午10:31
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加管理员</title>
</head>
<body>
<div class="page-content">
    <c:if test="${!empty errorMsg}">
        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-6">
                <div class="alert alert-danger">
                    <button data-dismiss="alert" class="close" type="button">
                        <i class="icon-remove"></i>
                    </button>

                    <strong>
                        <i class="icon-remove"></i>
                            ${errorMsg}
                    </strong>
                </div>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-xs-12">
            <form action="${website}admin/update/${id}" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="oldPwd"> 旧密码 </label>
                    <div class="col-sm-9">
                        <input id="oldPwd" name="oldPwd" class="col-xs-10 col-sm-5" type="password" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="newPwd"> 新密码 </label>
                    <div class="col-sm-9">
                        <input id="newPwd" name="newPwd" class="col-xs-10 col-sm-5" type="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="confirmPwd"> 确认密码 </label>
                    <div class="col-sm-9">
                        <input id="confirmPwd" name="confirmPwd" class="col-xs-10 col-sm-5" type="password" placeholder="Password">
                    </div>
                </div>
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                        <button id="update-btn" type="submit" class="btn btn-info">
                            <i class="icon-ok bigger-110"></i>
                            修改
                        </button>

                        &nbsp; &nbsp; &nbsp;
                        <button type="reset" class="btn">
                            <i class="icon-undo bigger-110"></i>
                            重置
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${staticWebsite}assets/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${staticWebsite}assets/js/jquery.validate.min.js"></script>
<script>
    $(function(){
        $('form').validate({
            rules: {
                oldPwd: {
                    required: true
                },
                newPwd: {
                    required: true
                },
                confirmPwd: {
                    required: true,
                    equalTo: '#newPwd'
                }
            },

            messages: {
                oldPwd: {
                    required: '请输入旧密码'
                },
                newPwd: {
                    required: '请输入新密码'
                },
                confirmPwd: {
                    required: '请再次输入密码',
                    equalTo: '与新密码输入不一致'
                }
            },
            errorPlacement: function(error, element) {
                error.appendTo(element.parent());
            },
            submitHandler: function() {
                $('form').ajaxSubmit({
                    target: '#ajax_target'
                });
            }
        });
    });
</script>
</body>
</html>