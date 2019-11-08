<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<hr />
        <footer>
       		<jsp:useBean id="now" class="java.util.Date" />
            <p>&copy; <fmt:formatDate value="${now}" pattern="yyyy"/><span> Written by M & J</span></p>
        </footer>
        
</body>
</html>