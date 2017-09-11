<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav>
	<h1 class="menu__title"><spring:message code="menu.header"/></h1>
	<ul class="menu__link">
		<li><a href="/news/list"><spring:message code="menu.link.list"/></a></li>
		<li><a href="/news/modify"><spring:message code="menu.link.create"/></a></li>
	</ul>
</nav>