<%-- User: guojun.jiao Date: 2019/1/18 Time: 上午11:53 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>

    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script>
        function req(){
            $.ajax({
                url:"convert",
                data:"1-jiaoguojun",
                type:"POST",
                contentType:"application/x-wisely",
                success:function(data){
                    $("#resp").html(data);
                }
            })
        }
    </script>
</body>
</html>

