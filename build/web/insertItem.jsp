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

      <!-- User -->
        <c:if test="${param.item == 'user'}" >
        <div class="col-md-7">
            <form action="MainController" method="POST">
            <table border="1" class="table table-secondary">
                <tbody>
                    <tr>
                        <td class="text-center text-uppercase ">User ID:</td>
                        <td>
                            <input class="input-group-text text-center bg-light  col-md-12" type="text" value="${DTO.userID}" name="txtUserID"/>
                            <p>${requestScope.INVALID.userIdError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Full Name:</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtFullName" value="${DTO.fullName}" />
                            <p>${requestScope.INVALID.userNameError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Year Of Birth:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtYob" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${DTO.yob}" />"/>
                            <p>${requestScope.INVALID.yobError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Email:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtEmail" value="${DTO.email}"/>
                        <p>${requestScope.INVALID.emailError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Address:</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtAddress" value="${DTO.address}"/>
                        <p>${requestScope.INVALID.addressError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Role:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtRole" value="${DTO.role}"/>
                        <p>${requestScope.INVALID.roleError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Room:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between col-md-12" type="text" name="txtRoom" value="${DTO.roomID.roomID}"/>
                        <p>${requestScope.INVALID.roomError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="hidden" name="txtSearch" value="" />
                            <input type="hidden" name="item" value="user" />
                            <button class="btn btn-block btn-info align-content-around" name="action" value="InsertUser" >Add</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
        <div class="col-md-1">
         </div>
        <!-- Sidebar Widgets Column -->
        <div class="col-md-4 position-relative">
          <form action="MainController" method="POST">
               <!-- Search Widget -->
                <div class="card mb-4">
                  <h5 class="card-header">Search</h5>
                  <div class="card-body">
                    <div class="input-group">
                        <input type="text" name="txtSearch" class="form-control" placeholder="Search User">
                      <span class="input-group-btn">
                          <button name="action" value="SearchUser" type="submit" class="btn btn-info">Go!</button>
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
        </c:if>
        
        <!--Device-->
        <c:if test="${param.item == 'device'}">
             <div class="col-md-7">
            <form action="MainController" method="POST">
            <table border="1" class="table table-secondary">
                <tbody>
                    <tr>
                        <td>Device ID:</td>
                        <td>
                            <input class="input-group-text text-center bg-light  col-md-12" type="text" name="txtDeviceID" value="${DTO.deviceID}"/>
                            <p>${requestScope.INVALID.deviceIDError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Device Name:</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtDeviceName"  value="${DTO.deviceName}"/>
                            <p>${requestScope.INVALID.deviceNameError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Bought Date</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtBoughtDate" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${DTO.boughtDate}" />"/>
                            <p>${requestScope.INVALID.boughtDateError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtType" value="${DTO.type}"  />
                        <p>${requestScope.INVALID.typeError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Period of Guarantee</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtPOG" value="${DTO.periodOfGuarantee}" />
                        <p>${requestScope.INVALID.periodOfGuaranteeError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtStatus" value="${DTO.status}" />
                        <p>${requestScope.INVALID.statusError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Room:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between col-md-12" type="text" name="txtRoomID" value="${DTO.roomID.roomID}"/>
                        <p>${requestScope.INVALID.roomIDError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtImage" value="${DTO.image}"/>
                        <p>${requestScope.INVALID.imageError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtDescription" value="${DTO.description}"/>
                        <p>${requestScope.INVALID.descriptionError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="hidden" name="item" value="device" />
                            <button class="btn btn-block btn-info align-content-around" name="action" value="InsertDevice" >Add</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
        <div class="col-md-1">
         </div>
        <!-- Sidebar Widgets Column -->
        <div class="col-md-4 position-relative">
          <form action="MainController" method="POST">
               <!-- Search Widget -->
                <div class="card mb-4">
                  <h5 class="card-header">Search</h5>
                  <div class="card-body">
                    <div class="input-group">
                        <input type="text" name="txtSearch" class="form-control" placeholder="Search User">
                      <span class="input-group-btn">
                          <button name="action" value="SearchUser" type="submit" class="btn btn-info">Go!</button>
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
        </c:if>
        
        <!--Room-->
        <c:if test="${param.item == 'room'}">
             <div class="col-md-7">
            <form action="MainController" method="POST">
            <table border="1" class="table table-secondary">
                <tbody>
                    <tr>
                        <td>User ID:</td>
                        <td>
                            <input class="input-group-text text-center bg-light  col-md-12" type="text" name="txtUserID"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Full Name:</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtFullName" />
                            <p>${requestScope.INVALID.userNameError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Year Of Birth:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtYob"/>
                            <p>${requestScope.INVALID.yobError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtEmail" />
                        <p>${requestScope.INVALID.emailError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>
                            <input class="input-group-text bg-light  col-md-12" type="text" name="txtAddress"/>
                        <p>${requestScope.INVALID.addressError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Role:</td>
                        <td>
                            <input class="input-group-text bg-light col-md-12" type="text" name="txtRole" />
                        <p>${requestScope.INVALID.roleError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center text-uppercase ">Room:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between col-md-12" type="text" name="txtRoom" />
                        <p>${requestScope.INVALID.roomError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="hidden" name="txtSearch" value="" />
                            <button class="btn btn-block btn-info align-content-around" name="action" value="AddUser" >Add</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
        <div class="col-md-1">
         </div>
        <!-- Sidebar Widgets Column -->
        <div class="col-md-4 position-relative">
          <form action="MainController" method="POST">
               <!-- Search Widget -->
                <div class="card mb-4">
                  <h5 class="card-header">Search</h5>
                  <div class="card-body">
                    <div class="input-group">
                        <input type="text" name="txtSearch" class="form-control" placeholder="Search User">
                      <span class="input-group-btn">
                          <button name="action" value="SearchUser" type="submit" class="btn btn-info">Go!</button>
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
        </c:if>
    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->