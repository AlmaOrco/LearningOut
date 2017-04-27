<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
	<title><fmt:message key="title"/></title>
</head>
<body>
	<h1><fmt:message key="heading"/></h1>
	<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
	<h3>Places</h3>
	<c:forEach items="${model.places}" var="place">
		<h4><c:out value="${place.namePlace}"/><br></h4>
		<c:out value="${place.location}"/><br>
		<c:out value="${place.province}"/><br>
		<c:out value="${place.postalCode}"/><br><br>
	</c:forEach>
</body>
</html>