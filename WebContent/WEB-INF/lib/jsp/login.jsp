<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>





<div class="header">
	<h1>Welcome Back to Scholar</h1>
</div>
<section>

	<c:url var="formAction" value="/login" />
	<form action="${formAction}" method="POST">
	
	<div class="form-group">
		<select>
			<option value="admin">Admin</option>
			<option value="teacher">Teacher</option>
			<option value="student">Student</option>
		</select>
	</div>
	
	
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	  </div>
	  <div class="form-group form-check">
	    <input type="checkbox" class="form-check-input" id="exampleCheck1">
	    <label class="form-check-label" for="exampleCheck1">Remember Me</label>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	  
	</form>



</section>






<%@include file="common/footer.jsp" %>
