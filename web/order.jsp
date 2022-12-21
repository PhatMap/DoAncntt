<%-- 
    Document   : cart
    Created on : Nov 6, 2022, 12:27:37 AM
    Author     : TranTrungPhat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Ao Only</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    
    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="topbar.jsp"></jsp:include>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <jsp:include page="navbar.jsp"></jsp:include>
    <!-- Navbar End -->


    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Order</a>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-12 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Bill ID</th>
                            <th>Date time</th>
                            <th>Total</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                        <c:forEach items="${Blist}" var="o">
                        <tr>
                            <td class="align-middle">${o.id}</td>
                            <td class="align-middle">${o.datetime}</td>
                            <td class="align-middle"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.total}"/> VNĐ</td>
                            <td class="align-middle">${o.status}</td>
                            <td>
                                <a style="color: black" href="controlBillDetail?id=${o.id}" ><i class="fa fa-search"></i>Detail</a>
                            </td>
                            <td>
                                <c:if test="${o.status eq 'Completed'}"><a href="controlCustomerDeleteBill?action=delete&id=${o.id}" style="color: red">Cancel Order</a></c:if>
                                <c:if test="${o.status eq 'Canceled' || o.status eq 'Not Received'}"><a href="controlCustomerDeleteBill?id=${o.id}" style="color: red">Cancel Order</a></c:if>
                            </td>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Cart End -->


    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
