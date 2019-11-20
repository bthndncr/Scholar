<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/dashboardHeader.jsp" %>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/School">GradeBook </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
  
	  <form action="displayGrades" method="POST">

			<select name="grade">
				<option>Grade</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select> 
			
			<select class="ml-2" name="code">
				<option>Section</option>
				<option value="A">A</option>
				<option value="B">B</option>
			</select>
			
			 <select class="ml-2" name="sort">
			    <option>Sort</option>
			    <option value="first_name">By First Name</option>
			    <option value="last_name"> By Last Name</option>
			    <option value="points_earned">By Points</option>
		  	</select>
		
		
			<button class="btn btn-outline-secondary btn-sm ml-2" type="submit">Search</button>
		</form>
  </div>
</nav>

<table class="table">
	<thead class="thead-light">
	    <tr>
	      <th scope="col">Grade</th>
	      <th scope="col">Section</th>
	      <th scope="col">First</th>
	      <th scope="col">Last</th>
	      <th scope="col">Title</th>
	      <th scope="col">Points Earned</th>
	    </tr>
	  </thead>
	  
<c:forEach items="${grades}" var="grade" >
	
	    <tr>
	      <td>${classGrade}</td>
	      <td>${classCode}</td>
	      <td>${grade.firstName}</td>
	      <td>${grade.lastName}</td>
	      <td>${grade.assignmentTitle}</td>
	      <td>${grade.pointsEarned}</td>
	    </tr>
	
</c:forEach>
</table>





	





<%@include file="common/footer.jsp" %>