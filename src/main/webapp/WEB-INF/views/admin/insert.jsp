<%--
  User: zhangteng
  Date: 13-12-11 上午10:30
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
    <div class="row">
        <div class="col-xs-12">
            <form action="${website}admin/insert" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="name"> 用户名 </label>
                    <div class="col-sm-9">
                        <input id="name" name="name" class="col-xs-10 col-sm-5" type="text" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="password"> 密码 </label>
                    <div class="col-sm-9">
                        <input id="password" name="password" class="col-xs-10 col-sm-5" type="password" placeholder="Password">
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
                        <button id="insert-btn" type="submit" class="btn btn-info">
                            <i class="icon-ok bigger-110"></i>
                            添加
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
<script type="text/javascript" src="${staticWebsite}assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script>
    $(function(){
        $('form').validate({
            rules: {
                name: {
                    required: true
                },
                password: {
                    required: true
                },
                confirmPwd: {
                    required: true,
                    equalTo: '#newPwd'
                }
            },

            messages: {
                name: {
                    required: '请输入用户名'
                },
                password: {
                    required: '请输入密码'
                },
                confirmPwd: {
                    required: '请再次输入密码',
                    equalTo: '与密码输入不一致'
                }
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