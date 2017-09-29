<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<div class="page-name">
		<span class="page-name-base"><spring:message code="prop.page.name.base"/></span> 
		<span class="page-name-arrows">>></span><spring:message code="prop.page.name.list"/>
	</div> 
	<ul> 
		<c:forEach var="article" items="${articles}">
			<li class="article" data-id="${article.id}">
				<div>
					<span class="article__date"><fmt:formatDate pattern="MM/dd/yyyy" value="${article.date}"/></span> 
					<span class="article__title">${article.title}</span> 
				</div>
				<div class="article__brief">${article.brief}</div>
				<div class="article__management">
					<a href="/news/view/${article.id}"><spring:message code="prop.form.button.view"/></a>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/news/modify/${article.id}"><spring:message code="prop.form.button.edit"/></a>
						<input class="article__checkbox" type="checkbox"/>
					</security:authorize>
				</div>
			</li> 
		</c:forEach> 
	</ul> 

	<div class="view__buttons">
		<input type="hidden" name="${_csrf.headerName}" value="${_csrf.token}"/>	
		<button class="view__button" id="delete-list-article" onclick="deleteListArticle()"><spring:message code="prop.form.button.delete"/> </button>
	</div>
</div>