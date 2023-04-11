<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết nhân viên</title>
    <style>
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
    CHI TIẾT NHÂN VIÊN
</h1>
<table style="margin: 0 auto; width: 400px">
    <tbody style="text-align: center">
    <tr>
        <td>Mã NV</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Họ tên</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Nữ</td>
        <td><input <c:if test="${employee.male == true}">checked</c:if> type="checkbox" value="${employee.male}"></td>
    </tr>
    <tr>
        <td>Ngày sinh</td>
        <td>${employee.birthDay}</td>
    </tr>
    <tr>
        <td>Địa chỉ</td>
        <td>${employee.address}</td>
    </tr>
    <tr>
        <td>Số ĐT</td>
        <td>${employee.phone}</td>
    </tr>
    <tr>
        <td>Phòng ban</td>
        <td>${employee.department}</td>
    </tr>
    <tr>
        <td>Chức vụ</td>
        <td>${employee.title}</td>
    </tr>
    <tr>
        <td>Lương căn bản</td>
        <td>${employee.wageRange}</td>
    </tr>
    </tbody>
</table>
<div style="text-align: center">
    <a class="btn" href="/dsnhanvien">Danh sách nhân viên</a>
    <a class="btn" href="/viewsuanhanvien/${employee.id}">Sửa</a>
</div>
</body>
</html>