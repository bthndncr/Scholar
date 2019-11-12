<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>



<div class="header">
	<h1>Welcome to Scholar</h1>
</div>

<section>

	<form>
	  <div class="form-group">
	    <label for="firstName">First Name</label>
	    <input type="text" class="form-control"  placeholder="First Name">
	  </div>
	  <div class="form-group">
	    <label for="lastName">Last Name</label>
	    <input type="text" class="form-control"  placeholder="Last Name">
	  </div>
	  
	  <div class="form-group">
		<select id="role">
			<option value="admin">Admin</option>
			<option value="teacher">Teacher</option>
			<option value="student">Student</option>
		</select>
	</div>
	  
	   <div class="form-group">
	    <label for="Email1">Email address</label>
	    <input type="email" class="form-control" placeholder="Enter email">
	  </div>
	  
	  <div class="form-group">
	    <label for="Password1">Password</label>
	    <input type="password" class="form-control"placeholder="Password">
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>


	





</section>






<%@include file="common/footer.jsp" %>
