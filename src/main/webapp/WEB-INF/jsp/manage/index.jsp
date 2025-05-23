<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>${ViewBag.Title}.</h2>

<p class="text-success">${ViewBag.StatusMessage}</p>
<div>
    <h4>Change your account settings</h4>
    <hr/>
    <dl class="dl-horizontal">
        <!-- 비밀번호 설정 여부 -->
        <dt>Password:</dt>
        <dd>
            [
            <c:choose>
                <c:when test="${IndexViewModel.hasPassword}">
                    <a href="${pageContext.request.contextPath}/Manage/ChangePassword">Change your password</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/Manage/SetPassword">Create</a>
                </c:otherwise>
            </c:choose>
            ]
        </dd>
        <!-- 외부 로그인 -->
        <dt>External Logins:</dt>
        <dd>
            ${fn:length(indexViewModel.logins)} [
            <a href="${pageContext.request.contextPath}/Manage/ManageLogins">Manage</a> ]
        </dd>
        <!-- 2단계 인증 안내 -->
        <!-- <dt>Two-Factor Authentication:</dt>
        <dd>
            <p>
                There are no two-factor authentication providers configured. See <a href="http://blog.naver.com/hong227">this article</a>
                for details on setting up this SpringBoot application to support two-factor authentication.
            </p>

            <%-- 실제 인증 설정 후 아래 폼 사용 가능 --%>
            <c:choose>
                <c:when test="${IndexViewModel.twoFactor}">
                    <form:form method="post" action="${pageContext.request.contextPath}/manage/disableTwoFactorAuthentication" cssClass="form-horizontal" role="form">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        Enabled
                        <input type="submit" value="Disable" class="btn btn-link"/>
                    </form:form>
                </c:when>
                <c:otherwise>
                    <form:form method="post" action="${pageContext.request.contextPath}/manage/enableTwoFactorAuthentication" cssClass="form-horizontal" role="form">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        Disabled
                        <input type="submit" value="Enable" class="btn btn-link"/>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </dd> -->
        <dt>Two-Factor Authentication:</dt>
        <dd>
            <p>
                There are no two-factor authentication providers configured. See <a href="http://blog.naver.com/hong227">this article</a>
                for details on setting up this SpringBoot application to support two-factor authentication.
            </p>
        </dd>
    </dl>
</div>