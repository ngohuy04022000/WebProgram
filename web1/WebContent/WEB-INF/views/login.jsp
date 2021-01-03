<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./login.css">
<script src="login.js"></script>
</head>
<body>
	<script>
        function checkForm(){
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
        }
    </script>
   
    <form class="box" name="form" action="" method="post">
        <h2 class="title">Đăng nhập</h2>
        <h4 class="input-title">Tài khoản</h4>
        <input type="text" name="taikhoan" placeholder="Tài khoản"/>
        <h4 class="input-title">Mật khẩu</h4>
        <input type="password" name="matkhau" placeholder="Mật khẩu"/>
    <input type="submit" name="dangnhap" value="Đăng nhập" onclick="return checkForm()"/>
    </form>
</body>
</html>