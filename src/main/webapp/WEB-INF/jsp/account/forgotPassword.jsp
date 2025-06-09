<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*" %>
<%@ page import="kr.hhp227.springboot.model.ForgotPasswordViewModel" %>
<%
    request.setAttribute("ForgotPasswordViewModel", new ForgotPasswordViewModel());
    request.setAttribute("ViewBag", Map.of("Title", "Forgot your password?"));
%>

<h2>${ViewBag.Title}.</h2>

<form:form method="POST" modelAttribute="ForgotPasswordViewModel" cssClass="form-horizontal" action="ForgotPassword">
    <!-- CSRF 토큰 예시 (Spring Security 사용 시) -->
    <!--
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    -->
    <h4>Enter your email.</h4>
    <hr/>

    <form:errors path="*" cssClass="text-danger"/>

    <div class="form-group">
        <label class="col-md-2 control-label" for="email">Email</label>
        <div class="col-md-10">
            <form:input path="email" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" class="btn btn-default" value="Email Link"/>
        </div>
    </div>
</form:form>