<body>
	<%@include file="form.jsp"%>
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

	<c:forEach items="${findList}" var="codeshare">
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
</body>
