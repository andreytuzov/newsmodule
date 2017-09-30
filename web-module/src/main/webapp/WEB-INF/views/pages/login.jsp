<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div> 
	<form class="form" action="<c:url value="login_process"/>" method="post"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td></td>
				<td>	
					<c:if test="${not empty param.error}">
						<span class="error"><spring:message code="prop.form.authentication.error"/></span> 
					</c:if>
				</td>
			</tr>
			<tr class="table__field">
				<td class="form__label"><label for="username"><spring:message code="prop.form.label.username"/></label></td>
				<td class="form__input"><input class="size-medium" type="text" name="username" autofocus="autofocus"/></td>  
			</tr>
			<tr class="table__field">
				<td class="form__label"><label for="password"><spring:message code="prop.form.label.password"/></label></td>
				<td class="form__input"><input class="size-medium" type="password" name="password"/></td>
			</tr>
			<tr>     
				<td></td>
				<td><button class="form__button"><spring:message code="prop.form.button.login"/></button></td>	
			</tr>  
		</table>
	</form>	
</div>