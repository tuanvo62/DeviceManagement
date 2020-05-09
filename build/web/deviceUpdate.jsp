<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="adminHeader.jsp" %>
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">
      <small>Subheading</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="admin.jsp">Home</a>
      </li>
      <li class="breadcrumb-item active">Device Details</li>
    </ol>

    <!-- Portfolio Item Row -->
    <div class="row">

      <div class="col-md-6">
        <img src="image/${DTO.image}" alt="Avatar" class="img-fluid">
      </div>

      <div class="col-md-6">
        <h3 class="my-3">Device Details</h3>
        <form action="MainController" method="POST">
            <table border="1" class="table table-secondary">
                <tbody>
                    <tr>
                        <td>Device ID:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtDeviceID" value="${DTO.deviceID}" readonly="true"/>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>Device Name:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtDeviceName" value="${DTO.deviceName}" />
                            <p>${requestScope.INVALID.deviceNameError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Bought Date</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtBoughtDate" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${DTO.boughtDate}" />" />
                            <p>${requestScope.INVALID.boughtDateError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtType" value="${DTO.type}" />
                        <p>${requestScope.INVALID.typeError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Period of Guarantee</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtPOG" value="${DTO.periodOfGuarantee}" />
                        <p>${requestScope.INVALID.periodOfGuaranteeError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtStatus" value="${DTO.status}" />
                        <p>${requestScope.INVALID.statusError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Room:</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtRoomID" value="${DTO.roomID.roomID}" />
                        <p>${requestScope.INVALID.roomIDError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <input class="input-group-text bg-light align-content-between" type="text" name="txtDescription" value="${DTO.description}" />
                        <p>${requestScope.INVALID.descriptionError}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Update:</td>
                        <td>
                            <input type="hidden" name="txtImage" value="${DTO.image}" />
                            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                            <button class="btn btn-block btn-info align-content-around" name="action" value="UpdateDevice" >Update</button>
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
