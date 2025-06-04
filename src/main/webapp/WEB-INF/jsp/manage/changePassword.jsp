<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="kr.hhp227.springboot.model.ChangePasswordViewModel" %>
<%
    request.setAttribute("ChangePasswordViewModel", new ChangePasswordViewModel());
    request.setAttribute("ViewBag", Map.of("Title", "Change Password"));
%>

<h2>${ViewBag.Title}.</h2>

<form:form modelAttribute="ChangePasswordViewModel" method="post" action="${pageContext.request.contextPath}/Manage/ChangePasswordProcess" class="form-horizontal" role="form">

    <!-- CSRF 토큰 예시 (Spring Security 사용 시) -->
    <!--
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    -->

    <h4>Change Password Form</h4>
    <hr>
    <div class="validation-summary-errors text-danger">
        <ul>
            <c:forEach var="msg" items="${prioritizedErrors}">
                <li class="text-danger">${msg}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="OldPassword">Current password</label>
        <div class="col-md-10">
            <form:password path="oldPassword" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="NewPassword">New password</label>
        <div class="col-md-10">
            <form:password path="newPassword" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="ConfirmPassword">Confirm new password</label>
        <div class="col-md-10">
            <form:password path="confirmPassword" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" value="Change password" class="btn btn-default">
        </div>
    </div>
</form:form>