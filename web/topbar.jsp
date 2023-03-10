<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div class="container-fluid">
        <div class="row bg-secondary py-1 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center h-100">
                    <a class="text-body mr-3" href=""></a>
                    <a class="text-body mr-3" href=""></a>
                    <a class="text-body mr-3" href=""></a>
                    <a class="text-body mr-3" href=""></a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <c:if test="${sessionScope.acc == null}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">My Account</button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a href="controlLogin"><button class="dropdown-item" type="button">Sign in</button></a>
                            <a href="signup.jsp"><button class="dropdown-item" type="button">Sign up</button></a>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                    <div class="btn-group">
                        <button style="color:blue;background-color:lightskyblue;border:2px solid lightskyblue;" type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Hello: ${sessionScope.acc.email}</button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a href="controlLogout"><button class="dropdown-item" type="button">Sign out</button></a>
                            <a href="controlProfile"><button class="dropdown-item" class="dropdown-item" type="button">Profile</button></a>
                            <c:if test="${sessionScope.acc.issell == true}"><a href="controlOrder"><button class="dropdown-item" class="dropdown-item" type="button">Seller Access</button></a></c:if>
                            <c:if test="${sessionScope.acc.isadmin == true}"><a href="controlAdmin"><button class="dropdown-item" class="dropdown-item" type="button">Admin Access</button></a></c:if>
                        </div>
                    </div>
                    </c:if>
                </div>
                <div class="d-inline-flex align-items-center d-block d-lg-none">
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-heart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-shopping-cart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="controlShop" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">Ao</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Only</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
                <form action="controlSearch" method="post">
                    <div class="input-group">
                        <input value="${keepword}" name="search" type="text" class="form-control" placeholder="Search for products">
                        <div  class="input-group-append">
                            <button type="submit" class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4 col-6 text-right">
                <p class="m-0">Customer Service(Zalo)</p>
                <h5 class="m-0">0367562350</h5>
            </div>
        </div>
    </div>