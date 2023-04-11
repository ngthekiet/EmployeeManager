<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách nhân viên</title>
    <style>
        body {
            margin: 0 auto;
            padding: 0;
        }

        td {
            border: 1px solid black;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            text-align: center;
        }

        .btn {
            text-decoration: none;
            border: solid 1px darkgrey;
            background-color: darkgrey;
            color: black;
            border-radius: 5px;
        }

        .btn:hover {
            cursor: pointer;
            background-color: azure;
        }
    </style>
</head>
<body>
<h1 style="text-align: center; font-size: 50px">
    DANH SÁCH NHÂN VIÊN
</h1>
<div style="margin: 0 auto; text-align: center; margin-bottom: 20px">
    <div style="background-color: cadetblue">Tổng số nhân viên: ${numEmployee}</div>
    <div>
        <a class="btn" href="/viewthemnhanvien">Thêm nhân viên</a>
    </div>
</div>
<table style="width: 1200px">
    <thead>
    <tr style="font-weight: bold; font-size: 25px; background-color: cadetblue">
        <td>
            Sửa
        </td>
        <td>
            Chọn
        </td>
        <td>
            Mã NV
        </td>
        <td>
            Họ Tên
        </td>
        <td>
            Ngày sinh
        </td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty listEmployee}">
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td>
                    <a class="btn" href="/viewsuanhanvien/${employee.id}">Sửa</a>
                </td>
                <td>
                    <input type="checkbox">
                </td>
                <td>
                    <a href="/chitietnhanvien/${employee.id}">${employee.id}</a>
                </td>
                <td>
                        ${employee.name}
                </td>
                <td>
                        ${employee.birthDay}
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
    <tfoot>

    </tfoot>
</table>
<div>
    ${test.name}
</div>
</body>
</html>
