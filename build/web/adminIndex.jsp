  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">User Management
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="admin.jsp">Home</a>
      </li>
      <li class="breadcrumb-item active">User-Management</li>
    </ol>

    <div class="row">

      <!-- Blog Entries Column -->
      <div class="col-md-8">
          <h1 class="title01-top mb-3" >Hello ${sessionScope.USERROLE} - ${sessionScope.USERID}</h1>
              <c:if test="${requestScope.USERINFO != null}" >
                  <c:if test="${not empty requestScope.USERINFO}" var="checkList">
                      <form action="MainController" method="POST">
                        <div class="row">
                        <h2>User List</h2>
                      <table border="2" class="table table-bordered table-striped">
                          <thead>
                              <tr>
                                  <th class="thead-dark">User ID</th>
                                  <th>User Name</th>
                                  <th>Year Of Birth</th>
                                  <th>Address</th>
                                  <th>Role</th>
                                  <th>Room</th>
                                  <th>Delete</th>
                              </tr>
                          </thead>
                          <tbody>
                              <c:forEach items="${requestScope.USERINFO}" var="dto">
                              <tr>
                                  <td>
                                  <c:url var="updateLink" value="MainController">
                                            <c:param name="action" value="EditUser" />
                                            <c:param name="userID" value="${dto.userID}" />
                                            <c:param name="txtSearch" value="${param.txtSearch}" />
                                        </c:url>
                                        <a href="${updateLink}">${dto.userID}</a>
                                  </td>
                                  <td>${dto.fullName}</td>
                                  <td><fmt:formatDate pattern="dd-MM-yyyy" value="${dto.yob}" /></td>
                                  <td>${dto.address}</td>
                                  <td>${dto.role}</td>
                                  <td>${dto.roomID.roomID}</td>
                                  <td>
                                       <c:url var="deleteLink" value="MainController">
                                            <c:param name="action" value="DeleteUser" />
                                            <c:param name="userID" value="${dto.userID}" />
                                            <c:param name="txtSearch" value="${param.txtSearch}" />
                                        </c:url>
                                      <a href="${deleteLink}"><p class="btn btn-secondary bg-danger">Delete</p></a>
                                  </td>
                              </tr>
                              </c:forEach>
                          </tbody>
                      </table>
                              </div>
                    </form>
                  </c:if>
                  <c:if test="${!checkList}">
                      No recored found
                  </c:if>
              </c:if>


      </div>

      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">
          <form action="MainController" method="POST">
               <!-- Search Widget -->
                <div class="card mb-4">
                  <h5 class="card-header">Search</h5>
                  <div class="card-body">
                    <div class="input-group">
                        <input type="text" name="txtSearch" class="form-control" placeholder="Search User">
                      <span class="input-group-btn">
                          <button name="action" value="SearchUser" type="submit" class="btn btn-secondary">Go!</button>
                      </span>
                    </div>
                  </div>
                </div>
          </form>

        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">Categories</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">Web Design</a>
                  </li>
                  <li>
                    <a href="#">HTML</a>
                  </li>
                  <li>
                    <a href="#">Freebies</a>
                  </li>
                </ul>
              </div>
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">JavaScript</a>
                  </li>
                  <li>
                    <a href="#">CSS</a>
                  </li>
                  <li>
                    <a href="#">Tutorials</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">Side Widget</h5>
          <div class="card-body">
              <c:url var="addLink" value="insert.jsp">
                  <c:param name="item" value="user" />
              </c:url>
              <a class="btn btn-block btn-info align-content-between" href="${addLink}">Add new user</a>
          </div>
        </div>

      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->