<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>





<div class="header">
	<h1>Welcome Back to Scholar</h1>
</div>

<section class="text-center">

	<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
	<c:url var="formAction" value="/login" />
	<form action="${formAction}" method="POST">
	
	<div class="form-group">
		<select id="role">
			<option value="admin">Admin</option>
			<option value="teacher">Teacher</option>
			<option value="student">Student</option>
		</select>
	</div>
	
	
	  <label for="inputEmail" class="sr-only">Email address</label>
	  <input type="email" id="inputEmail" class="form-control mb-1" placeholder="Email address" required autofocus>
	  
	  <label for="inputPassword" class="sr-only">Password</label>
	  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	  <div class="checkbox mb-3">
    	<label>
      	<input type="checkbox" value="remember-me"> Remember me
    	</label>
  	  </div>
  	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	  
	</form>



</section>






<%@include file="common/footer.jsp" %>
