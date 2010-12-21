<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!--  alterado inicio  -->
 <script src="<c:url value="/javascripts/codemirror.js"/>" type="text/javascript"></script>
 <!--  alterado fim  -->
<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		 ${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="<c:url value="/codeshares"/>" method="post">
  
  <c:if test="${not empty codeshare.id}">
    <input type="hidden" name="codeshare.id" value="${codeshare.id}"/>
    <input type="hidden" name="_method" value="put"/>
  </c:if>

  <div class="field">
    Name:<br />
    <input type="text" name="codeshare.name" value="${codeshare.name}"/>
  </div>
  <div class="field">
   <!--  alterado inicio  -->
    Code (<a href="#" onclick="javascript:start();">highlight</a>):<br />
   <textarea id="code" name="codeshare.code" rows="30" cols="30">${codeshare.code}</textarea>
    <!--  alterado fim  -->
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
    <button type="submit">send</button>
  </div>
</form>
 <!--  alterado inicio  -->
<script type="text/javascript">
function start(){
	var editor = CodeMirror.fromTextArea('code', {
	    height: "650px",
	    parserfile: ["../javascripts/tokenizejava.js","../javascripts/parsejava.js"],
	    stylesheet: "../stylesheets/javacolors.css",
	    path: "../javascripts/",
		tabMode : "shift"
	  });
	  return true;
}
</script>
 <!--  alterado fim  -->
<a href="<c:url value="/codeshares"/>">Back</a>

