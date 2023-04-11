<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm nhân viên</title>
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
<h1 style="text-align: center; font-size: 50px">THÊM NHÂN VIÊN</h1>
<div style="display: flex; justify-content: center">
    <form:form action="/themnhanvien" method="post" modelAttribute="employee">
        <div>
            <form:label path="id">*Mã NV</form:label>
            <form:input path="id"/>
        </div>
        <div>
            <form:label path="name">*Họ tên</form:label>
            <form:input path="name"/>
        </div>
        <div>
            <form:label path="male">*Nữ</form:label>
            <form:checkbox path="male"/>
        </div>
        <div>
            <form:label path="birthDay">*Ngày sinh</form:label>
            <form:input path="birthDay"/>
            <form:label path="birthDay">yyyy-mm-dd</form:label>
        </div>
        <div>
            <form:label path="address">Địa chỉ</form:label>
            <form:input path="address"/>
        </div>
        <div>
            <form:label path="phone">Số ĐT</form:label>
            <form:input path="phone"/>
        </div>
        <div>
            <form:label path="department">Phòng ban</form:label>
            <form:select path="department" items="${listDepartment}"/>
        </div>
        <div>
            <form:label path="title">Chức vụ</form:label>
            <form:select path="title" items="${listTitle}"/>
        </div>
        <div>
            <form:label path="wageRange">Lương căn bản</form:label>
            <form:input path="wageRange"/>
        </div>
        <div style="margin-top: 20px; text-align: center">
            <form:button>Lưu</form:button>
            <a class="btn" href="/dsnhanvien">Hủy bỏ</a>
        </div>
    </form:form>
</div>
<c:if test="${not empty error}">
    <div style="text-align: center; color: red">
            ${error}
    </div>
</c:if>
</body>
</html>
