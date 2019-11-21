<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/dashboardHeader.jsp" %>

<script type="text/javascript">
	
	const h3 = document.querySelector("h3");
	const form = document.querySelector("edit");
	h3.addEventListener("click", (e) => {
		e.preventDefault();
		form.classList.remove("d-none");
	})
	
</script>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/School">Updates Grades </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
  
	  <form action="inputGrades" method="POST">

			<select name="classId">
				<c:forEach items="${classes}" var="theClass">
					<option value="${theClass.classId}">${theClass.gradeLevel}${theClass.classCode}</option>
				</c:forEach>
			</select> 
		
			<button class="btn btn-outline-secondary btn-sm ml-2" type="submit">Search</button>
		</form>
		
		
		
  </div>
</nav>
		
			<c:forEach items="${assignments}" var="assignment">
				<h3>${assignment.title }</h3>	
			</c:forEach>
			
			<form class="d-none" id="edit">
				<p>Hello I am there</p>
			
			</form>
			



<%@include file="common/footer.jsp" %>