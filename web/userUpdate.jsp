<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="adminHeader.jsp" %>
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Portfolio Item
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="admin.jsp">Home</a>
      </li>
      <li class="breadcrumb-item active">User Details</li>
    </ol>

    <!-- Portfolio Item Row -->
    <div class="row">

      <div class="col-md-7">
        <img src="image/avatar.png" alt="Avatar" class="img-fluid">
      </div>

      <div class="col-md-4">
        <h3 class="my-3">User Details</h3>
        <form action="MainController" method="POST">
            <table border="1" class="table table-secondary">
                <tbody>
                    <tr>
                        <td>User ID:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtUserID" value="${DTO.userID}" readonly="true"/>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>Full Name:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtFullName" value="${DTO.fullName}" />
                            <p>${requestScope.INVALID.userNameError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Year Of Birth:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtYob" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${DTO.yob}" />" />
                            <p>${requestScope.INVALID.yobError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtEmail" value="${DTO.email}" />
                        <p>${requestScope.INVALID.emailError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtAddress" value="${DTO.address}" />
                        <p>${requestScope.INVALID.addressError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Role:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtRole" value="${DTO.role}" />
                        <p>${requestScope.INVALID.roleError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Room:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtRoom" value="${DTO.roomID.roomID}" />
                        <p>${requestScope.INVALID.roomError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Update:</td>
                        <td>
                            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                            <button class="btn btn-block btn-info align-content-around" name="action" value="UpdateUser" >Update</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
      </div>

    </div>
    <!-- /.row -->

    <!-- Related Projects Row -->
    <h3 class="my-4">Related Projects</h3>

    <div class="row">

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
<%@include file="footer.jsp" %>
