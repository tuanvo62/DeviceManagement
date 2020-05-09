<%-- 
    Document   : Login
    Created on : Feb 27, 2020, 5:10:06 PM
    Author     : macbookpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/28ba37fb35.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <style>
            .my-5{
                margin-top: 7rem!important;
            }
            body{
                /* The image used */
                background-image: url("image/body_backgrounf.jpg");
                min-height: 100%;
                /* Center and scale the image nicely */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }
            .divider-text {
                position: relative;
                text-align: center;
                margin-top: 15px;
                margin-bottom: 15px;
            }
            .divider-text span {
                padding: 7px;
                font-size: 12px;
                position: relative;   
                z-index: 2;
            }
            .divider-text:after {
                content: "";
                position: absolute;
                width: 100%;
                border-bottom: 1px solid #ddd;
                top: 55%;
                left: 0;
                z-index: 1;
            }
        </style>
    </head>
    <body>
  <div class="container">
      <div class="row" >
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Login</h5>
                <p class="divider-text">
                    <span class="bg-light"><i class="fab fa-tumblr-square fa-5x"></i></span>
                </p>
                <form class="form-signin" action="MainController" method="POST">
                <div class="form-label-group">
                    <input type="text" id="inputEmail" class="form-control" placeholder="UserID" name="txtUserId"  autofocus/><br/>
                    <font color="red">
                    ${requestScope.INVALID.userIdError}
                    </font>
                </div>
                    <br/>

                <div class="form-label-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="txtPassword"/><br/>
                    <font color="red">
                    ${requestScope.INVALID.passwordError}
                    </font>
                </div>
                    <br/>

                <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input" id="customCheck1" />
                  <label class="custom-control-label" for="customCheck1">Remember password</label>
                </div>
                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" name="action" value="Login">Login</button>
                <hr class="my-4">
                <p class="text-center">Don't have account? <a href="Register.jsp">Register</a> </p>     

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
    </body>
</html>
