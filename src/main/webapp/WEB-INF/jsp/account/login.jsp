<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hhp227.springboot.model.LoginViewModel" %>
<%
    request.setAttribute("LoginViewModel", new LoginViewModel());
    request.setAttribute("ViewBag", Map.of("Title", "로그인"));
%>

<h2>${ViewBag.Title}.</h2>
<div class="row">
    <div class="col-md-8">
        <section id="loginForm">
            <form:form method="post" modelAttribute="LoginViewModel" cssClass="form-horizontal" role="form" action="LoginProcess">
                <form:hidden path="${_csrf.parameterName}" value="${_csrf.token}"/>
                <h4>로컬 계정을 사용하여 로그인하십시오.</h4>
                <hr />
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <div class="validation-summary-errors text-danger">
                        <ul>
                            <li>Invalid login attempt.</li>
                        </ul>
                    </div>
                    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
                </c:if>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="UserName">사용자 이름</label>
                    <div class="col-md-10">
                        <form:input path="username" cssClass="form-control"/>
                        <form:errors path="username" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="Password">암호</label>
                    <div class="col-md-10">
                        <form:password path="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <div class="checkbox">
                            <form:checkbox path="rememberMe" />
                            <form:label path="rememberMe">사용자 이름 및 암호 저장</form:label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" value="로그인" class="btn btn-default" />
                    </div>
                </div>
                <p>
                    로컬 계정이 없는 경우 <a href="Register">등록</a>.
                </p>
            </form:form>
        </section>
    </div>
    <div class="col-md-4">
        <section id="socialLoginForm">

            <h4>Use another service to log in.</h4>
            <hr />
            <div>
                <p>
                    There are no external authentication services configured. See
                    <a href="https://blog.naver.com/hong227/221500700577">this article</a>
                    for details on setting up this SpringBoot application to
                    support logging in via external services.
                </p>
            </div>

        </section>
    </div>
</div>
<script src="<c:url value="/webjars/jquery/3.3.1/jquery.js"/>"></script>
<script src="<c:url value="/webjars/jquery-validation/1.19.3/jquery.validate.min.js"/>"></script>
