<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>${ViewBag.Title}.</h2>

<form action="ChangePassword" class="form-horizontal" method="post" role="form">
</form>
<form action="/Manage/ChangePassword" class="form-horizontal" method="post" role="form">

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
            <input class="form-control" data-val="true" data-val-required="Current password 필드가 필요합니다." id="OldPassword" name="OldPassword" type="password">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="NewPassword">New password</label>
        <div class="col-md-10">
            <input class="form-control" data-val="true" data-val-length="The New password must be at least 6 characters long." data-val-length-max="100" data-val-length-min="6" data-val-required="New password 필드가 필요합니다." id="NewPassword" name="NewPassword" type="password">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label" for="ConfirmPassword">Confirm new password</label>
        <div class="col-md-10">
            <input class="form-control" data-val="true" data-val-equalto="The new password and confirmation password do not match." data-val-equalto-other="*.NewPassword" id="ConfirmPassword" name="ConfirmPassword" type="password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <input type="submit" value="Change password" class="btn btn-default">
        </div>
    </div>
</form>