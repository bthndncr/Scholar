<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>

<c:url var="gradeInputURL" value="gradeInput" />
<form action="${gradeInputURL}" method="POST" >
<table>
<c:forEach items="${students}" var="student">
<tr>
	<td>${student}</td>
	<td><label for="pointsEarned">Points Earned:</label></td>
	<td>${pointsPossible}</td>
</tr>
</c:forEach>
<input type="submit" value="Enter Grades"/>
</table>
</form>

<%@include file="common/footer.jsp" %>