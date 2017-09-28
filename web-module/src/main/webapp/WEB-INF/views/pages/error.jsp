<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="header-error">
	<c:choose>
		<c:when test="${errCode eq 404}">
			<spring:message code="prop.page.error.404"/>
		</c:when>
		<c:when test="${errCode eq 204}">
			<spring:message code="prop.page.error.204"/>
		</c:when>
	</c:choose>
</div>
