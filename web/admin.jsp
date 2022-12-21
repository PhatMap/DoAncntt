    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin</title>
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
                            <h2><b>Admin Dashboard</b></h2>
                        </div>
                        <div class="col-sm-8">
                            <h2>
                                <b>
                                    <a href="controlHome" style="color: white">Back to Shop</a>
                                </b>
                            </h2>
                        </div>
                        <div class="col-sm-1">
                            <a href="controlPManage" ><button style="color: black">Manage product</button></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Seller</th>
                            <th>Admin</th>
                            <th>Email</th>
                            <th>Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${accList}" var="o">
                            <tr>
                                <td>${o.acid}</td>
                                <td>
                                    ${o.issell}
                                    <a href="controlAdmin?id=${o.acid}&setAccess=true&action=sell"><button>set True</button></a>
                                    <a href="controlAdmin?id=${o.acid}&setAccess=false&action=sell"><button>set False</button></a>
                                </td>
                                <td>
                                    ${o.isadmin}
                                    <a href="controlAdmin?id=${o.acid}&setAccess=true&action=admin"><button>set True</button></a>
                                    <a href="controlAdmin?id=${o.acid}&setAccess=false&action=admin"><button>set False</button></a>
                                </td>
                                <td>${o.email}</td>
                                <td>${o.password}</td>
                                <td>
                                    <a href="controlAdmin?action=delete&id=${o.acid}"  class="delete" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>