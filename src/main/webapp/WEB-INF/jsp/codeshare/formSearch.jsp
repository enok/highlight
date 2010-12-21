<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/codeshares/find"/>" method="post">
  
  <c:if test="${not empty (codeshare.name or codeshare.tags)}">
    <input type="hidden" name="codeshare" value="${codeshare}"/>
    <input type="hidden" name="_method" value="post"/>
  </c:if>

  <div class="field">
    Name:<br />
    <input type="text" name="codeshare.name" value="${codeshare.name}"/>
  </div>
  <div class="field">
    Language:<br />
    <!--  alterado inicio  -->
    <select name="codeshare.language" id="codeshare.language">
	  <option value="java">java</option>
	</select>
	 <!--  alterado fim  -->
  </div>
  <div class="field">
    Tags:<br />
    <input type="text" name="codeshare.tags" value="${codeshare.tags}"/>
  </div>
  <div class="actions">
    <button type="submit">find</button>
  </div>
</form>


