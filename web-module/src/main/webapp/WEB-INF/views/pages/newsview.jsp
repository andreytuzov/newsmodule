<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<td class="view__data">
				<fmt:formatDate pattern="MM/dd/yyyy" value="${article.date}"/>
			</td>
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
	<div class="comments">
		<h3><spring:message code="prop.comments.header"/> <span class="comments__count">${comments.size()}</span></h3> 
		<c:forEach var="comment" items="${comments}">
			<div class="comments__item" data-id="${comment.id}">
				<hr/>
				<p>
					<span class="comments__user">${comment.user.username}</span> 
					<span class="comments__date">
						<fmt:formatDate pattern="MM/dd/yyyy в HH:mm" value="${comment.date}"/> 
					</span> 
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<button class="button-right" onclick="deleteComment(${comment.id}, ${article.id})"><spring:message code="prop.form.button.delete"/></button>
					</security:authorize>
				</p>
				<p class="comments__text">${comment.text}</p> 
			</div>
		</c:forEach>
		<security:authorize access="isAuthenticated()">
			<div>
				<form:form action="/news/view/${article.id}" method="post" modelAttribute="commentForm">
					<form:hidden path="articleId"/> 
					<form:errors path="text" cssClass="error"/>
					<form:textarea path="text" rows="10" style="width: 100%; margin: 10px 0 10px 0;"></form:textarea> 
					<button><spring:message code="prop.comments.button"/></button>
				</form:form>
			</div>
		</security:authorize>
		<security:authorize access="isAnonymous()">
			<p><spring:message code="prop.comments.login"/></p>  
		</security:authorize>
	</div> 
</div>



