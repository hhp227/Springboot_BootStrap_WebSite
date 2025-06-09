<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%
    request.setAttribute("ViewBag", Map.of("Title", "Forgot Password Confirmation"));
%>

<hgroup class="title">
    <h1>${ViewBag.Title}.</h1>
</hgroup>
<div>
    <p>
        Please check your email to reset your password.
    </p>
</div>