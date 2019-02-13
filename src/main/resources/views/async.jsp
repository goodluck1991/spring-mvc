<%-- User: guojun.jiao Date: 2019/1/18 Time: 下午6:18 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>servlet async support</title>
</head>
<body>
    <div id="msgFrompPush"></div>
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript">
        deferred();//页面打开向后台发送请求
        function deferred(){

            $.get('defer',function(data,status){
                $("#msgFrompPush").html(data+"<br/>");
                deferred();//再次向后台请求
            });
        }
    </script>

</body>
</html>



