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
		    <option value="6">6</option>
		    <option value="7">7</option>
		  </select>
		
		
		  <select class="ml-2" name="code">
		    <option>Section</option>
		    <option value="A">A</option>
		    <option value="B">B</option>
		  </select>
		  
		  <select class="ml-2" name="sort">
		    <option>Sort</option>
		    <option value="*">Pull All</option>
		    <option value="lastName">Grade by Student</option>
		  </select>
		
		
			<button class="btn btn-outline-secondary btn-sm ml-2" type="submit">Search</button>
		</form>
  </div>
</nav>


	





<%@include file="common/footer.jsp" %>