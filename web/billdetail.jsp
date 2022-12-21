<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Profile</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Bill <b>Detail</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="controlProfile" method="post">
                            <input name="action" type="hidden" value="save">
                            <div class="modal-header">						
                                <h4 class="modal-title">Bill</h4>
                                <c:if test="${sessionScope.acc.issell==true}"><a href="controlOrder"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a></c:if>
                                <c:if test="${sessionScope.acc.issell==false}"><a href="controlCustomerBill"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a></c:if>
                            </div>
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>Date time</label>
                                    <p>${bill.datetime}</p>
                                </div>
                                <div class="form-group">
                                    <label>Bill ID</label>
                                    <p>${bill.id}</p>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <p>${account.email}</p>
                                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Plist}" var="o">
                            <tr>
                                <td>${o.name}</td>
                                <td>${o.amount}</td>
                                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.price}"/></td>
                                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.amount*o.price}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>   
                                
                                <div class="form-group">
                                    <label>Total</label>
                                    <p>${bill.total}</p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>