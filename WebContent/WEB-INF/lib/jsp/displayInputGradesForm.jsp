<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/dashboardHeader.jsp" %>

<script type="text/javascript">
	
	function toggleForm(){
		
		/* const allButtons = document.querySelectorAll(".shit"); */
		const form = document.getElementById("edit");
/* 		allButtons.forEach((button) => {
				e.preventDefault(); */
				form.classList.remove("d-none"); 

	/* 	}); */

		
	}
	
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
		
			<div class="container">
				<div class="row">
					<div class="col-6">
						<c:forEach items="${assignments}" var="assignment">
							<button class="shit d-block mb-1" onclick="toggleForm()">${assignment.title }</button>	
						</c:forEach>
					</div>
					<div class="col-6">
						<form class="d-none" id="edit">
							<input type="text" placeholder="firstName"></input>
							<input type="text" placeholder="lastName"></input>
							<input type="number" min=0 max=100 placeholder="point posibble"></input>
							<label>Point Possible</label>
							<input type="number" placeholder="${assignment.pointsEarned }"></input>
							<c:forEach items="${students}" var="student">
							${student.firstName} ${student.lastName }
							</c:forEach>
			
			
			
			
						</form>
					</div>
				</div>
				
			</div>
			
			







<%@include file="common/footer.jsp" %>