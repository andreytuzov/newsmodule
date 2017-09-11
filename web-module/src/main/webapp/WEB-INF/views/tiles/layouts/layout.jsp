<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<title><tiles:getAsString name="title"/></title>
	<link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"></link>
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header"/>
	</header>

	<section id="sidemenu">
		<tiles:insertAttribute name="menu"/>
	</section>

	<section id="site-content">
		<tiles:insertAttribute name="body"/>
	</section>
	
	<footer id="footer">
		<tiles:insertAttribute name="footer"/>
	</footer>
	
	
	<script src="<c:url value='/static/js/jquery-1.11.1.js'/>"></script>
	<script src="<c:url value='/static/js/dynamic.js'/>"></script>
		
</body>	
</html>