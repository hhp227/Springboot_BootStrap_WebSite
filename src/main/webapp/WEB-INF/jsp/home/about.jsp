<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    ((Map) request.getAttribute("ViewBag")).put("Title", "About");
%>
<h2>${ViewBag.Title}.</h2>
<h3>${ViewBag.Message}</h3>

<p>Use this area to provide additional information.</p>