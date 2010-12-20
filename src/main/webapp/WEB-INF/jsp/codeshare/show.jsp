<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

<p>
  <b>Name:</b>
   ${codeshare.name}
</p>
<p>
  <b>Code:</b>
   ${codeshare.code}
</p>
<p>
  <b>Language:</b>
   ${codeshare.language}
</p>
<p>
  <b>Tags:</b>
   ${codeshare.tags}
</p>

<a href="<c:url value="/codeshares/${codeshare.id}/edit"/>">Edit</a>
<a href="<c:url value="/codeshares"/>">Back</a>

</body>
