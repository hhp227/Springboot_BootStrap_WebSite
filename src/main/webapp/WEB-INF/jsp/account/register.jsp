<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hhp227.springboot.model.RegisterViewModel" %>
<%
    request.setAttribute("RegisterViewModel", new RegisterViewModel());
    request.setAttribute("ViewBag", Map.of("Title", "등록"));
%>

<h2>${ViewBag.Title}.</h2>

<form:form method="post" modelAttribute="RegisterViewModel" cssClass="form-horizontal" role="form" action="RegisterProcess">
    <input name="__RequestVerificationToken" type="hidden" value="yWAZvXaFcp4rTbs02dPxUO7HAN_UkRC1lk5lf4YHLfOxhLAEpU84WXRenpDrQgV826S55n-aPC0aOqNkebg2jFHHArbeua09_rYCmU2dfCE1" />
    <h4>새 계정을 만드십시오.</h4>
    <hr />
    <div class="validation-summary-errors text-danger">
        <ul>
            <form:errors path="*" cssClass="text-danger"/> <!-- 점(<li><form:errors path="*" cssClass="text-danger" /></li>)이 빠져있음 -->
        </ul>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="UserName">사용자 이름</label>
        <div class="col-md-10">
            <form:input path="username" cssClass="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="Password">암호</label>
        <div class="col-md-10">
            <form:password path="password" cssClass="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="ConfirmPassword">암호 확인</label>
        <div class="col-md-10">
            <form:password path="confirmPassword" cssClass="form-control" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" class="btn btn-default" value="등록" />
        </div>
    </div>
</form:form>