<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav>
	<h1 class="menu__title"><spring:message code="prop.menu.header"/></h1>
	<ul class="menu__link">
		<li><a href="/news/list"><spring:message code="prop.menu.link.list"/></a></li>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/news/modify/0"><spring:message code="prop.menu.link.create"/></a></li>
		</security:authorize>
	</ul>
</nav>