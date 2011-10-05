<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<% String logoutUrl = UserServiceFactory.getUserService().createLogoutURL("/"); %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Admin</title>
    <!-- 
        These lines are required by CMFaur
        [START REQUIRED CODE]
    -->
    <script type="text/javascript" language="javascript" src="/burrito/burrito.nocache.js"></script>
    <!-- [/END REQUIRED CODE] -->
  </head>
  <body>
    <div class="admin-top">
        Admin <a class="logout" href="<%=logoutUrl %>">Sign out</a>
    </div>

    <!-- 
        These lines are required by CMFaur
        [START REQUIRED CODE]
     -->
    <div id="burrito-admin"></div>
    <iframe src="javascript:''" id="__gwt_historyFrame" style="width:0;height:0;border:0"></iframe>
    <!-- [/END REQUIRED CODE] -->

  </body>
</html>