<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<div class="page-name">
	<span class="page-name-base"><spring:message code="prop.page.name.base"/></span> 
	<span class="page-name-arrows">>></span><spring:message code="prop.page.name.view"/>
</div> 

<div class="view">
	<table>
		<tr class="view__field">
			<td class="view__label"><spring:message code="prop.form.label.title"/></td>
			<td class="view__data">${article.title}</td> 
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="prop.form.label.date"/></td>
			<td class="view__data">${article.date}</td>
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="prop.form.label.brief"/></td>
			<td class="view__data">${article.brief}</td>
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="prop.form.label.content"/></td>
			<td class="view__data">${article.content}</td>
		</tr>
	</table>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="view__buttons">
			<button class="view__button" onclick="editArticle(${article.id})"><spring:message code="prop.form.button.edit"/></button>
			<button class="view__button" onclick="deleteArticle(${article.id})"><spring:message code="prop.form.button.delete"/></button>
		</div>
	</security:authorize>
</div>



