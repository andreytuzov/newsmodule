<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div>   
	<h2 class="header__title">
		<spring:message code="prop.header.title"/>
		<security:authorize access="isAnonymous()">
			<span class="header__authentication">
				<a href="/news/login"><spring:message code="prop.header.authentication.login"/></a>      
			</span>  
		</security:authorize> 
		<security:authorize access="isAuthenticated()">
			<span class="header__username"><security:authentication property="principal.username"/> | </span>
			<form action="/news/logout" method="post" class="inline">  
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
				<button class="link-button"><spring:message code="prop.header.authentication.logout"/></button>
			</form>  
		</security:authorize>
	</h2> 
	<div class="header__language"> 
		<a href="?lang=en"><spring:message code="prop.header.language.english"/></a>
		<a href="?lang=ru"><spring:message code="prop.header.language.russian"/></a>
	</div>
</div>
