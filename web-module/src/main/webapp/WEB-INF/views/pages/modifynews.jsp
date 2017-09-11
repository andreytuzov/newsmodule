<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>
	<div class="page-name">
		<span class="page-name-base"><spring:message code="page.name.base"/></span> 
		<span class="page-name-arrows">>></span><spring:message code="page.name.modify"/>
	</div> 

	<form:form class="form" action="/news/modify" method="post" modelAttribute="article">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td></td>
				<td><form:errors path="title" cssClass="error"/></td>
			</tr>
			<tr class="form__field">
				<td class="form__label"><form:label path="title"><spring:message code="form.label.title"/></form:label></td>
				<td class="form__input"><form:input class="form-field__title" path="title"/></td> 
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="date" cssClass="error"/></td>
			</tr>
			<tr class="form__field">
				<td class="form__label"><form:label path="date"><spring:message code="form.label.date"/></form:label></td>
				<td class="form__input"><form:input class="form-field__date" path="date"/></td>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="brief" cssClass="error"/></td>
			</tr>
			<tr class="form__field">
				<td class="form__label"><form:label path="brief"><spring:message code="form.label.brief"/></form:label></td>
				<td class="form__input"><form:textarea rows="5" class="form-field__brief" path="brief"/></td>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="content" cssClass="error"/></td>
			</tr>
			<tr class="form__field">
				<td class="form__label"><form:label path="content"><spring:message code="form.label.content"/></form:label></td>
				<td class="form__input"><form:textarea rows="10" class="form-field__content" path="content"/></td> 
			</tr>
		</table>
		<div class="form__buttons">
			<button class="form__button"><spring:message code="form.button.save"/></button>
			<button class="form__button" onclick="goback(); return false;"><spring:message code="form.button.cancel"/></button>
		</div>
	</form:form>
	
</div>