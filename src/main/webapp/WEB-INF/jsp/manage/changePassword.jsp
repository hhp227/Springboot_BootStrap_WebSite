<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>${ViewBag.Title}.</h2>

<form:form modelAttribute="ChangePasswordViewModel" method="post" action="${pageContext.request.contextPath}/Manage/ChangePasswordProcess" class="form-horizontal" role="form">
<!-- <form action="ChangePasswordProcess" class="form-horizontal" method="post" role="form"> -->

    <!-- CSRF 토큰 예시 (Spring Security 사용 시) -->
    <!--
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    -->

    <h4>Change Password Form</h4>
    <hr>
    <!-- 에러 메시지 표시 예시 -->
    <c:if test="${not empty errorMessage}">
        <div class="text-danger">${errorMessage}</div>
    </c:if>
    <div class="form-group">
        <label class="col-md-2 control-label" for="OldPassword">Current password</label>
        <div class="col-md-10">
            <!-- <input class="form-control" data-val="true" data-val-required="Current password 필드가 필요합니다." id="OldPassword" name="oldPassword" type="password"> -->
            <form:password path="oldPassword" cssClass="form-control"/>
            <form:errors path="oldPassword" cssClass="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="NewPassword">New password</label>
        <div class="col-md-10">
            <!-- <input class="form-control" data-val="true" data-val-length="The New password must be at least 6 characters long." data-val-length-max="100" data-val-length-min="6" data-val-required="New password 필드가 필요합니다." id="NewPassword" name="newPassword" type="password"> -->
            <form:password path="newPassword" cssClass="form-control"/>
            <form:errors path="newPassword" cssClass="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="ConfirmPassword">Confirm new password</label>
        <div class="col-md-10">
            <!-- <input class="form-control" data-val="true" data-val-equalto="The new password and confirmation password do not match." data-val-equalto-other="*.NewPassword" id="ConfirmPassword" name="confirmPassword" type="password"> -->
            <form:password path="confirmPassword" cssClass="form-control"/>
            <form:errors path="confirmPassword" cssClass="text-danger"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" value="Change password" class="btn btn-default">
        </div>
    </div>
</form:form>