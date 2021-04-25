<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authorize access="isAuthenticated()">
    <form action="Account/LogOff" id="logoutForm" method="post">
        <input name="__RequestVerificationToken" type="hidden" value="sEgrdauMlz7XLFsKaIlgg3qf0KOT157cUdxS9r0QyFochueT5srMK4KfVKxg67ifvOpg4hsfvM-wscPrTMpUJMxDZ2fK_Q0k1OiHJao3pg5gFsbxwaQeT73AYGuegvyEBfSZFuomFPMqCOVkCPVlow2">
        <ul class="nav navbar-nav navbar-right">
            <li>
                <sec:authentication property="principal" var="user" />
                <a href="Manage" title="Manage">Hello ${user.username}!</a>
            </li>
            <li><a href="javascript:document.getElementById('logoutForm').submit()">Log off</a></li>
        </ul>
    </form>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <ul class="nav navbar-nav navbar-right">
        <li><a href="Register" id="registerLink">등록</a></li>
        <li><a href="Login" id="loginLink">로그인</a></li>
    </ul>
</sec:authorize>