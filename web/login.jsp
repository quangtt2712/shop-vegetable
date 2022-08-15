<%-- 
    Document   : login
    Created on : Mar 11, 2022, 10:59:24 PM
    Author     : 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
    
<meta name="google-signin-client_id" content="1018276898060-74hbf8h8fqfd5te7dqkoh7aa37pjg11g.apps.googleusercontent.com.apps.googleusercontent.com">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://apis.google.com/js/platform.js" async defer></script>        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form action="login" class="form" method="post" id="form">
                            <h3 class="text-center text-info">Đăng Nhập</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div >
                            <div class="g-recaptcha" data-sitekey="6Le_99AeAAAAAD_I83ROyqPiMnf1oetO6fe_tyhK"></div>
                            <div id="error"></div>
                            <h3 class="text-danger">${error}</h3>
                            <button type="submit" name="" class="btn btn-info btn-md col-md-12" value="submit">submit</button>

                            <div class="g-signin2" data-onsuccess="onSignIn"></div>
                            <div id="register-link" class="text-right">
                                <a href="#" class="text-info">Register here</a>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script>
        window.onload = function () {
            let isValid = false;
            const form = document.getElementById("form");
            const error = document.getElementById("error");
            form.addEventListener("submit", function (event) {
                event.preventDefault();
                const response = grecaptcha.getResponse();
                if (response) {
                    form.submit();
                } else {
                    error.innerHTML = "sai captcha";
                }
            });
        }
    </script>
    

</body>