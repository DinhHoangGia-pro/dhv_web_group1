<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>KM to Miles</title>
</head>
<body>

<h2>Unit Convert</h2>
 <h1>Chuyển đổi giá trị</h1>

<form action="chuyendoi" method="post">
   

    Miles:
    <input type="number" name="mile">

    <button type="submit">Đổi sang km</button>
</form>




 <%
    Object result = request.getAttribute("result");

    if(result != null){
%>
<h1 style="color: rgb(69, 156, 190);">Kết quả chuyển đổi</h1>

    <h3>Result: <%= result %> miles</h3>

<%
    }
%>



</body>
</html>