<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/dashboardHeader.jsp" %>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Advance Search </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	
		<form action="searchInput" method="GET">

			<select name="grade">
				<option>Grade</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
			</select>
			
		<select class="ml-2" name= "code">
		    <option>Section</option>
		    <option value="A">A</option>
		    <option value="B">B</option>
		  </select>
		
		
		<button class="btn btn-outline-secondary btn-sm ml-2" type="submit">Search</button>
		</form>
	    
  </div>
</nav>

<table class="table">
	<thead class="thead-light">
	    <tr>
	      <th scope="col">First</th>
	      <th scope="col">Last</th>
	      <th scope="col">Gender</th>
	      <th scope="col">Birthday</th>
	    </tr>
	  </thead>
<c:forEach items="${students}" var="student" >
	
	  <tbody>
	    <tr>
	      <td>${student.firstName}</td>
	      <td>${student.lastName}</td>
	      <td>${student.gender}</td>
	      <td>${student.birthdate}</td>
	    </tr>
	
</c:forEach>
   
</table>



<%@include file="common/footer.jsp" %>