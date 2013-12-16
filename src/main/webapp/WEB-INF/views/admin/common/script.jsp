<%--
  User: zhangteng
  Date: 13-12-6 上午9:49
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticWebsite}assets/js/uncompressed/jquery-2.0.3.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='${staticWebsite}assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${staticWebsite}assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<script src="${staticWebsite}assets/js/bootstrap.min.js"></script>
<script src="${staticWebsite}assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${staticWebsite}assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="${staticWebsite}assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${staticWebsite}assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${staticWebsite}assets/js/jquery.slimscroll.min.js"></script>
<script src="${staticWebsite}assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="${staticWebsite}assets/js/jquery.sparkline.min.js"></script>
<script src="${staticWebsite}assets/js/flot/jquery.flot.min.js"></script>
<script src="${staticWebsite}assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${staticWebsite}assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="${staticWebsite}assets/js/ace-elements.min.js"></script>
<script src="${staticWebsite}assets/js/ace.min.js"></script>
<script src="${staticWebsite}assets/js/spin.min.js"></script>
<script src="${staticWebsite}assets/js/sco.ajax.js"></script>
<!-- inline scripts related to this page -->