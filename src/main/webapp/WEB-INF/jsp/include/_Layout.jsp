<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${ViewBag.Title} - 스프링부트 부트스트랩 웹사이트</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/Site.css" rel="stylesheet" />
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/springboot/">응용 프로그램 이름</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/springboot/">홈</a></li>
                <li><a href="/springboot/About">정보</a></li>
                <li><a href="/springboot/Contact">연락처</a></li>
            </ul>
            <%@include file="../include/_LoginPartial.jsp"%>
        </div>
    </div>
</div>
<div class="container body-content">
    <tiles:insertAttribute name="content" />
    <hr />
    <footer>
        <p>&copy; <%=Calendar.getInstance().get(Calendar.YEAR)%> - 스프링부트 부트스트랩 웹사이트</p>
    </footer>
</div>
<script src="<c:url value="/webjars/jquery/3.3.1/jquery.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>
</body>
</html>
