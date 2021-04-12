<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PT15301UD</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>
	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light bg-info">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">PT15301-UD</a>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Home</a>
	        </li>
	      </ul>
	    </div>
	  
		<c:if test="${not empty request.session.user}">
			<a class="btn btn-default">Logout</a>
		</c:if>
	  </div>
	</nav>
	<!-- End Header -->
	
	<div class="row">
		<div class="col-2 bg-primary">Sidebar</div>
		<div class="col-10">
			<!-- Contents -->
			<jsp:include page="${ view }" />
			<!-- End Contents -->
		</div>
	</div>
	
	<!-- Contents -->
	<div class="row bg-secondary">Footer</div>
	<!-- End Contents -->
</body>
</html>