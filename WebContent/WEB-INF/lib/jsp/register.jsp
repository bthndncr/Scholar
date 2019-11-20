<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jsp" %>



<div class="header">
	<h1>Welcome to Scholar</h1>
</div>

<section>

	<c:url var="registerUrl" value="/register"/>
	<form:form action="${registerUrl}" method="POST" modelAttribute="user">
	    <div class="form-group">
	        <label for="username">Username</label>
	        <form:input class="form-control" path="username" placeholder="Username"/>
	        <form:errors path="username" cssClass="bg-danger"/>
	    </div>
	    <div class="form-group">
	        <label for="password">Password</label>
	        <form:password class="form-control" path="password" placeholder="Password"/>
	        <form:errors path="password" cssClass="bg-danger"/>
	    </div>
	    <div class="form-group">
	        <label for="confirmPassword">Confirm Password</label>
	        <form:password class="form-control" path="confirmPassword" placeholder="Confirm Password"/>
	        <form:errors path="passwordMatching" cssClass="bg-danger"/>
	    </div>
	    
	    <fieldset>
	        <label for="role">Role</label>
	        <form:errors path="role" cssClass="bg-danger"/>
	        <div class="radio">
	            <label>
	                <form:radiobutton path="role" value="teacher" checked="checked"/>
	                Teacher
	            </label>
	        </div>
	        <div class="radio">
	            <label>
	                <form:radiobutton path="role" value="student"/>
	                Student
	            </label>
	        </div>
	    </fieldset>
	    <button type="submit" class="btn btn-primary">Register</button>
	</form:form>

	


</section>






<%@include file="common/footer.jsp" %>
