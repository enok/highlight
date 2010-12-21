<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		 ${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<h1>Resultado da Pesquisa</h1>

<table>
	<tr>
		<th>name</th>
		<th>code</th>
		<th>language</th>
		<th>tags</th>
		<th></th>
		<th></th>
		<th></th>
	</tr>

	<c:forEach items="${codeshareList}" var="codeshare">
		<tr>
			<td>${codeshare.name}</td>
			<td>${codeshare.code}</td>
			<td>${codeshare.language}</td>
			<td>${codeshare.tags}</td>
			<td><a href="<c:url value="/codeshares/${codeshare.id}"/>">show</a></td>
			<td><a href="<c:url value="/codeshares/${codeshare.id}/edit"/>">edit</a></td>
			<td>
			<form action="<c:url value="/codeshares/${codeshare.id}"/>"
				method="post"><input type="hidden" name="_method"
				value="delete" />
			<button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
			</form>
			</td>
		</tr>
	</c:forEach>
</table>

 <!--  alterado fim  -->
<a href="<c:url value="/codeshares"/>">Back</a>

