<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="dao.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>

    <style>
        table{
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td{
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }

        th{
            background-color: #f2f2f2;
        }

        h2{
            text-align: center;
        }
    </style>
</head>
<body>

    <h2>DANH SÁCH SẢN PHẨM</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Supplier ID</th>
            <th>Category ID</th>
            <th>Quantity Per Unit</th>
            <th>Unit Price</th>
            <th>Units In Stock</th>
        </tr>

        <%
            ProductDAO dao=new ProductDAO();
            List<Product> list = dao.getAllProducts();

            if(list != null){
                for(Product p : list){
        %>

        <tr>
            <td><%= p.getProductID() %></td>
            <td><%= p.getProductName() %></td>
            <td><%= p.getSupplierID() %></td>
            <td><%= p.getCategoryID() %></td>
            <td><%= p.getQuantityPerUnit() %></td>
            <td><%= p.getUnitPrice() %></td>
            <td><%= p.getUnitsInStock() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

</body>
</html>
```
