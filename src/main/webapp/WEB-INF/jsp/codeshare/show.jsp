<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
 <!--  alterado inicio  -->
<script src="<c:url value="/javascripts/codemirror.js"/>" type="text/javascript"></script>
 <!--  alterado fim  -->
<p>
  <b>Name:</b>
   ${codeshare.name}
</p>
<p>
 <!--  alterado inicio  -->
  Code (<a href="#" onclick="javascript:start();">highlight</a>):<br />
   <textarea id="code" name="codeshare.code" rows="30" cols="30">${codeshare.code}</textarea>
    <!--  alterado fim  -->
</p>
<p>
  <b>Language:</b>
   <!--  alterado inicio  -->
   <select name="codeshare.language" id="codeshare.language">
	  <option value="java">java</option>
	</select>
	 <!--  alterado fim  -->
</p>
<p>
  <b>Tags:</b>
   ${codeshare.tags}
</p>
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
<a href="<c:url value="/codeshares/${codeshare.id}/edit"/>">Edit</a>
<a href="<c:url value="/codeshares"/>">Back</a>

</body>
