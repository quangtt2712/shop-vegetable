<%-- 
    Document   : index
    Created on : Mar 11, 2022, 12:30:04 PM
    Author     : 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>Cửa hàng rau củ</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <%@include file = "components/navBarComponents.jsp" %>
        <!-- Header-->
        <header class="bg-black py-5">
            
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Cửa hàng rau củ</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Có thực mới vực được đạo</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row">
                    <div class="col-md-3 mb-5">
                        <h3>Phân Loại</h3>
                        <ul class="list-group">      
                            <c:forEach items="${sessionScope.listCategoryes}" var="C">
                                
                                <li class="list-group-item"><a href="filter-category?catagoryID=${C.catagoryID}">${C.catagoryName} </a></li>
                            </c:forEach>
                                             
                        </ul>
                    </div>
                    <div class="col-md-9">
                        
                        <h3>Danh Sách thực phẩm</h3>
                        <c:if test="${listProducts == null || listProducts.size() == 0}">
                            <h2 style="color: orange">Không tìm thấy</h2>
                        </c:if>
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                            
                            <c:forEach items="${listProducts}" var="B">
                                
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="${B.image}"
                                         alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder">${B.productName}</h5>
                                            <!-- Product price-->
                                            $${B.price}
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="add-to-cart?productId=${B.productID}">Thêm vào giỏ</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            
                                
                           
                        </div>
                    </div>
                </div>



            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Cửa hàng rau củ</p>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>