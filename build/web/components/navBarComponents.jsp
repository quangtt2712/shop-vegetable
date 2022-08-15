<%-- 
    Document   : navBarComponents
    Created on : Mar 11, 2022, 7:52:17 PM
    Author     : 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home">Trang Chủ</a></li>

            </ul>
            <form action="search" class="d-flex mx-auto">
                <input class="form-control me-2" type="search" placeholder="nhập thứ bạn muốn tìm" aria-label="Search" name="keyword">
                <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
            </form>
            <form class="d-flex" action="list-cart">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Giỏ hàng
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </button>
            </form>
            <c:choose>
                <c:when test="${sessionScope.account != null }">
                    <button type="submit" class="btn btn-info ms-lg-2">${sessionScope.account.roleID}</button>
                    <a href="logout" class="btn btn-info ms-lg-2">Logout</a>
                </c:when>
                <c:otherwise>

                    <form class="d-flex" action="login"> 
                        <button type="submit" class="btn btn-info ms-lg-2">Login</button>
                    </form>
                </c:otherwise>

            </c:choose>
        </div>
    </div>
</nav>
