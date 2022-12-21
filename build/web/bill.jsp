<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bill</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-3">
                            <h2>Manage <b>Order</b></h2>
                        </div>
                        <div class="col-sm-8">
                            <h2><b><a href="controlHome" style="color: white">Back to Shop</a></b></h2>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Account id</th>
                            <th>Date time</th>
                            <th></th>
                            <th>Total</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${billList}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.accid}</td>
                                <td>${o.datetime}<td>
                                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.total}"/> VNĐ</td>
                                <td>
                                    <c:if test="${o.status eq 'Completed'}"><a href="controlOrder?action=delete&id=${o.id}"  class="delete" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></c:if>
                                    <c:if test="${o.status eq 'Not Received' || o.status eq 'Canceled'}"><a href="controlOrder?action=refund&id=${o.id}"  class="delete" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></c:if>
                                </td>
                                <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown" style="color: black;background-color: greenyellow">${o.status}</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a href="controlOrder?action=status&id=${o.id}&status=Received"><button class="dropdown-item" type="button">Order Received</button></a>
                                        <a href="controlOrder?action=status&id=${o.id}&status=Shipping"><button class="dropdown-item" type="button">Order Shipping</button></a>
                                        <a href="controlOrder?action=status&id=${o.id}&status=Completed"><button class="dropdown-item" type="button">Order Completed</button></a>
                                        <a href="controlOrder?action=status&id=${o.id}&status=Canceled"><button class="dropdown-item" type="button">Order Canceled</button></a>
                                    </div>
                            </div>
                                </td>
                                <td>
                                    <a href="controlBillDetail?id=${o.id}" ><i class="fa fa-search"></i>Detail</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
        <script>
               
        </script>
    </body>
</html>