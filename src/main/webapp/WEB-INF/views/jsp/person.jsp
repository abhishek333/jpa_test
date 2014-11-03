<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.1.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<title>Person</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="firstUrl" value="/pages/1" />
<c:url var="lastUrl" value="/pages/${personPage.totalPages}" />
<c:url var="prevUrl" value="/pages/${currentIndex - 1}" />
<c:url var="nextUrl" value="/pages/${currentIndex + 1}" />

<div class="well">
	<div class="text-center">
	    <ul class="pagination">
	        <c:choose>
	            <c:when test="${currentIndex == 1}">
	                <li class="disabled"><a href="#" data-original-title="" title="">&lt;&lt;</a></li>
	                <li class="disabled"><a href="#" data-original-title="" title="">&lt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a href="${firstUrl}">&lt;&lt;</a></li>
	                <li><a href="${prevUrl}">&lt;</a></li>
	            </c:otherwise>
	        </c:choose>
	        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
	            <c:url var="pageUrl" value="/pages/${i}" />
	            <c:choose>
	                <c:when test="${i == currentIndex}">
	                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                </c:when>
	                <c:otherwise>
	                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                </c:otherwise>
	            </c:choose>
	        </c:forEach>
	        <c:choose>
	            <c:when test="${currentIndex == personPage.totalPages}">
	                <li class="disabled"><a href="#">&gt;</a></li>
	                <li class="disabled"><a href="#">&gt;&gt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a href="${nextUrl}">&gt;</a></li>
	                <li><a href="${lastUrl}">&gt;&gt;</a></li>
	            </c:otherwise>
	        </c:choose>
	    </ul>
	    <div class="text-center">
	    	<table class="table table-hover">
	    		<tr>
	    			<th>#</th>
	    			<th>Name</th>
	    		</tr>
		    	<c:forEach items="${personPage.content}" var="p">
		    		<tr>
		    			<td>${p.id}</td>
		    			<td>${p.name}</td>
		    		</tr>
		    	</c:forEach>
	    	</table>
	    </div>	
	</div>
</div>
</body>
</html>