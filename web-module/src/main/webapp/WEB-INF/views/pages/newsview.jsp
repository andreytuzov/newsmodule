<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-name">
	<span class="page-name-base"><spring:message code="page.name.base"/></span> 
	<span class="page-name-arrows">>></span><spring:message code="page.name.view"/>
</div> 

<div class="view">
	<table>
		<tr class="view__field">
			<td class="view__label"><spring:message code="form.label.title"/></td>
			<td class="view__data">${article.title}</td> 
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="form.label.date"/></td>
			<td class="view__data">${article.date}</td>
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="form.label.brief"/></td>
			<td class="view__data">${article.brief}</td>
		</tr>
		<tr class="view__field">
			<td class="view__label"><spring:message code="form.label.content"/></td>
			<td class="view__data">${article.content}</td>
		</tr>
	</table>
	<div class="view__buttons">
		<button class="view__button" onclick="editArticle(${article.id})"><spring:message code="form.button.edit"/></button>
		<button class="view__button" onclick="deleteArticle(${article.id})"><spring:message code="form.button.delete"/></button>
	</div>
</div>



