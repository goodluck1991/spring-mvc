<%-- User: guojun.jiao Date: 2019/1/18 Time: 下午6:18 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SSE Demo</title>
</head>
<body>
    <div id="msgFrompPush"></div>

    <script type="text/javascript" src="assets/js/jquery.min.js"/>
    <script type="text/javascript">
        if(!window.EventSource){
            var source = new EventSource('push');
            s = '';
            source.addEventListener('message',function(e){
                s++e.data+"<br/>";
                $("#msgFrompPush").html(s);
            });

            source.addEventListener('open',function(e){
                console.log("connection open ...");
            },false);

            source.addEventListener('error',function(e){
                if(e.readyState == EventSource.CLOSED){
                    console.log("connection close ...");
                }else{
                    console.log(e.readyState);
                }
            },false);
        }else{
            console.log("浏览器不支持SSE");
        }
    </script>
</body>
</html>

