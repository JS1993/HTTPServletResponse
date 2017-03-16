<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
    	function changeCode(){
    		var img = document.getElementsByTagName("img")[0];
    	    img.src = "/servlet/Login?time="+new Date().getTime();
    	}
    </script>
    <style type="text/css">
		#register {
			width:100%;
			text-align:center;
			margin-top:20px;
		}
	</style>
  </head>
  
  <body>
  <%
  		String msg = (String)request.getAttribute("msg");
  		if(msg!=null) out.print(msg);
   %>
     <div id="register">
     <form action="#" method="post">
      	用户名：&nbsp;&nbsp;<input type="text" name="userName"/><br><br>
      	&nbsp;密码：&nbsp;&nbsp;<input type="password" name="pwd"/><br><br>
      	验证码:&nbsp; &nbsp;<input type="text" name="code"/><br><br>
      	<img src="/servlet/Login" onclick="javascript:changeCode()"/><a href="javascript:changeCode()">看不清,换一张</a>
      	<br><br>
      	<input type="submit" value="登陆" formaction="/servlet/SkipPage"/>
     </form>
</div>
  </body>
</html>
