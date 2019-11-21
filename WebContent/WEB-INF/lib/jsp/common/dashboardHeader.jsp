<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:out value="${pageTitle}"/> Scholar </title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    
	<link href="<c:url value="css/site.css"/>" rel="stylesheet" type="text/css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" integrity="sha256-0rguYS0qgS6L4qVzANq4kjxPLtvnp5nn2nB5G1lWRv4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<style>
	section {
		margin: 5% 30% 20% 30%; ;
	}
</style>

<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<c:url var="home" value="/dashboard" />
  <a class="navbar-brand" href="${home}">SCHOLAR</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
  	<form action="#" method="#" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Quick Student Search" aria-label="Search">
      <button class="btn btn-sm btn-outline-success my-2 " type="submit">Search</button>
    </form>
    
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Students
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="search">Advance Search</a>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Staff
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">My Account</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Schedule</a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Grade Book
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <c:url var="gradePage" value="displayGrades" />
          <a class="dropdown-item" href="${gradePage}">Grades</a>
          <c:url var="inputGrades" value="inputGrades" />
          <a class="dropdown-item" href="${inputGrades}" >Update Grades</a>
          <a class="dropdown-item" href="#" >Assignments</a>
          
        </div>
      </li>
      
    </ul>
    
    <c:if test="${not empty appCurrentUser}">
    <ul class="navbar-nav">
       <li class="nav-item"><a class="nav-link" href="dashboard">${appCurrentUser.username}</a></li>
       
        <c:url var="logoffUrl" value="/logoff"/>
        <li>
            <form action="${logoffUrl}" method="POST" class="mt-1">
                <button type="submit" class="btn btn-sm btn-outline-danger">Sign Out</button>
            </form>
         </li>
        </ul>
     </c:if>

  </div>
</nav>

<!-- Login error message -->
<%-- <div class="container body-content">
    <c:if test="${not empty message}">
        <div class="message alert alert-danger" role="alert">
            <c:out value="${message}"/>
        </div>
    </c:if> --%>


