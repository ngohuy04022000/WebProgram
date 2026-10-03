<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="./asset/css/login.css">
<title>Đăng ký</title>
</head>
<body>
	<script>
        function checkForm(){
        	if(document.form.name.value=="")
            {
                 alert("Vui lòng nhập họ và tên!");
                 document.form.name.focus();
                 return false;

            }
            if(document.form.address.value=="")
            {
                 alert("Vui lòng nhập địa chỉ của bạn!");
                 document.form.address.focus();
                 return false;

            }
            if(document.form.email.value=="")
            {
                 alert("Vui lòng nhập tài khoản Email của bạn!");
                 document.form.email.focus();
                 return false;

            }
            if(document.form.taikhoan.value=="")
            {
                 alert("Vui lòng nhập tài khoản!");
                 document.form.taikhoan.focus();
                 return false;

            }
            if(document.form.matkhau.value=="")
            {
                alert("Vui lòng nhập mật khẩu!");
                document.form.matkhau.focus();
                 return false;
            }
            if(document.form.matkhau.value!=document.form.matkhau1.value)
            {
                alert("Mật khẩu nhập lại không trùng với mật khẩu trước đó! Vui lòng nhập lại");
                document.form.matkhau1.focus();
                return false;
            }
        }
    </script>
   
    <form class="box" name="form" action="registrationcheck" method="post">
        <h2 class="title">Đăng ký</h2>
        <c:choose>
            <c:when test="${param.error == 'exists'}"><p style="color: #ff6b6b;">Tài khoản đã tồn tại, vui lòng chọn tài khoản khác!</p></c:when>
            <c:when test="${param.error == 'password'}"><p style="color: #ff6b6b;">Mật khẩu nhập lại không trùng khớp!</p></c:when>
            <c:when test="${param.error == 'empty'}"><p style="color: #ff6b6b;">Vui lòng nhập đầy đủ thông tin!</p></c:when>
            <c:when test="${not empty param.error}"><p style="color: #ff6b6b;">Đăng ký thất bại, vui lòng thử lại!</p></c:when>
        </c:choose>
        <h4 class="input-title">Họ và tên</h4>
        <input type="text" name="name" placeholder="Họ và tên"/>
        <h4 class="input-title">Địa chỉ</h4>
        <input type="text" name="address" placeholder="Địa chỉ"/>
        <h4 class="input-title">Email</h4>
        <input type="text" name="email" placeholder="Email"/>
        <h4 class="input-title">Tài khoản</h4>
        <input type="text" name="taikhoan" placeholder="Tài khoản"/>
        <h4 class="input-title">Mật khẩu</h4>
        <input type="password" name="matkhau" placeholder="Mật khẩu"/>
        <h4 class="input-title">Nhập lại mật khẩu</h4>
        <input type="password" name="matkhau1" placeholder="Nhập lại mật khẩu"/>
    <input type="submit" name="dangky" value="Đăng ký" onclick="return checkForm()"/>
    </form>
</body>
</html>