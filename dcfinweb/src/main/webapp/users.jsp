<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.dcfin.idp.model.User"%>
<%@page import="java.util.List"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.104.2">
<title>Dashboard Template � Bootstrap v5.2</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">-->
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/dashboard.js"></script>
<script>
	function goToCreate() {
		window.location.href = "createUser.jsp"

	}
</script>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">
</head>
<body>

	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Deccan
			Financial </a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="logout.jsp">Sign out</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3 sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="dashboard.jsp"> <span
								data-feather="home" class="align-text-bottom"> </span> Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link" href="branch.jsp">
								<span data-feather="file" class="align-text-bottom"></span>
								Branch
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="loanProducts.jsp"> <span data-feather="file"
								class="align-text-bottom"></span> Loan Products
						</a></li>

						<li class="nav-item"><a class="nav-link" href="users.jsp">
								<span data-feather="shopping-cart" class="align-text-bottom"></span>
								Users
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="userProfiles.jsp"> <span data-feather="users"
								class="align-text-bottom"></span> User Profiles
						</a></li>
						<li class="nav-item"><a class="nav-link" href="groups.jsp">
								<span data-feather="bar-chart-2" class="align-text-bottom"></span>
								Groups
						</a></li>
						<li class="nav-item"><a class="nav-link" href="roles.jsp">
								<span data-feather="layers" class="align-text-bottom"></span>
								Roles
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
						<span>Saved reports</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle" class="align-text-bottom"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text" class="align-text-bottom"></span>
								Portfolio
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text" class="align-text-bottom"></span> Loan
								Requests
						</a></li>
					</ul>
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Users</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" onclick="goToCreate()"
								class="btn btn-sm btn-outline-secondary">Create</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar" class="align-text-bottom"></span>
							This week
						</button>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th scope="col">User ID</th>
								<th scope="col">User Name</th>
								<th scope="col">Email</th>
								<th scope="col">User Role</th>
								<!-- th scope="col">Function</th-->
							</tr>
						</thead>
						<tbody>
							<!-->
								</jsp:useBean> <jsp:setProperty
										property="*" name="userinfo" />
								<td><jsp:getProperty property="userId"
										name="userinfo" />
								</td>

								<td><jsp:getProperty property="userName"
										name="userinfo" /></td>
								<td><jsp:getProperty property="emailId"
										name="userinfo" /></td>
								<td><jsp:getProperty property="userRole"
										name="userinfo" /></td>




							<-->

							<!--tr
								<td>1,001</td>
								<td>John</td>
								<td>John@gmail.com</td>
								<td>Admin</td>
								<td><a class="nav-link" href="createUser.jsp"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Edit User
								</a> <a class="nav-link" href="#"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Delete User
								</a></td>
							</tr>
							<tr>
								<td>1,002</td>
								<td>Marina</td>
								<td>marina@yahoo.com</td>
								<td>HR</td>
								<td><a class="nav-link" href="createUser.jsp"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Edit User
								</a> <a class="nav-link" href="#"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Delete User
								</a></td>
							</tr>
							<tr>
								<td>1,003</td>
								<td>Peter</td>
								<td>peter@gmail.com</td>
								<td>Manager</td>
								<td><a class="nav-link" href="createUser.jsp"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Edit User
								</a> <a class="nav-link" href="#"> <span
										data-feather="file-text" class="align-text-bottom"></span>
										Delete User
								</a></td>
							<tr-->
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
</body>
</html>
