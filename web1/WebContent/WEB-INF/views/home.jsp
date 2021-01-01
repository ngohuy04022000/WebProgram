<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truyenhay.vn</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="stylesheet" href="./main.css">
<link rel="stylesheet" href="./base.css">
<link rel="stylesheet" href="./fonts/fontawesome-free-5.15.1-web/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&family=Source+Sans+Pro:wght@300;600&display=swap" rel="stylesheet">
</head>
<body>
	<div class="app">
            <header class="header">
                <div class="grid"> 
                    <nav class="header__navbar">
                        <ul class="header__navbar-list">
                            <img class="header__navbar--logo" src="./img/logo.png" alt="Logo">
                            <div class="header__item">
                                <li class="color header__item danhmuc_list"><span class="item" style="width:50%">
                                    <i class="fas fa-align-justify" ></i>
                                    Danh mục</span>
                                    <div class="danhmuc-theloai">
                                        <header class="header_danhmuc">
                                                <ul class="danhmuc-list">
                                                    <li class="item_dm"><a href="" class="item_loaidanhmuc">Truyện mới</a></li>
                                                    <li class="item_dm"><a href="" class="item_loaidanhmuc">Truyện hoàn thành</a></li>
                                                    <li class="item_dm"><a href="" class="item_loaidanhmuc">Lọc truyện</a></li>
                                                </ul>
                                        </header>
                                    </div>
                                </li>   
                            </div> 
                        </ul>
                        <ul class="header__login-search">
                                <input class="header__item-search" type="text" name="txtKeyword" id="txtKeyword" value="" placeholder="Tên truyện hoặc tác giả" class="form-control" autocomplete="off">
                                <a href="" class="icon-search"><i class="fas fa-search search"></i></a>
                                <li class="header__item-login">
                                    <a href="" class="item dangnhaptaikhoan" onclick="login()"><span>
                                        <i class="far fa-user-circle"></i>
                                        Đăng nhập</span>
                                    </a></li>
                                <span class="header__item-login vach">|</span>
                                <li class="header__item-login"><a href=""class="item dangkytaikhoan"><span style="width : 100%;" >Đăng ký</span></a></li>
                        </ul>
                        
                    </nav>
                </div>
                <div class="anhnen"></div>
                <div class="header__phanthan">
                    <div class="phandem"></div>
                        <div class="header__decu">
                            <div class="btv_decu">
                                <span class="header-title">BTV ĐỀ CỬ</span>
                                <div class="btv_decu-img">
                                <img src="./img/cam-huong-ly-poster-20200706-200x300.jpg" alt="" class="top1thinhhanh">
                                </div>
                                <h2 class ="btv_decu-tua">Tobi</h2>
                                <span class="btv_decu-chitiet">
                                    Giới thiệu vắn tắt: quyển sách lại danh<< đại sư huynh nói xong không đánh nữ nhân, kết quả lạt thủ lồi hoa>>,
                                </span>
                            </div>
                             <div class="header-topthinhhanh">
                                <span class="header-title">NGƯỜI ĐỌC ĐỀ CỬ</span>
                                <div class="header-topthinhhanh-list">
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                    <div class="header-topthinhhanh-item"><a href="" class="header-topthinhhanh-item-link">Toàn chức pháp sư dị năng</a></div>
                                </div>
                            </div>     
                    </div>
                    <div class="end">
                        <div class="gioithieu-end">
                            <h3 class="title-end">Giới thiệu</h3>
                            <span class="chitiet-end">Truyenhay.vn là website đọc truyện online được các thành viên nhóm 08 cập nhật và xây dưng nên.
                            Chúc các bạn có thời gian đọc truyện vui vẻ ^^!!!
                            </span>
                        </div>
                        <div class="lienhe-end">
                            <h3 class="title-end">Liên hệ</h3>
                            <ul>
                                <li><span class="item-title">Email:</span><a href="https://mail.google.com/" class="end-item">ngohuy04022000@gmail.com</a></li>
                                <li><span class="item-title">Phone:</span><a href="" class="end-item">0886904146</a></li>
                                <li><span class="item-title">Facebook:</span><a href="https://www.facebook.com/profile.php?id=100009480812209" class="end-item">Trí Huy Ngô</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="end-game"></div>
                </div>
            </header>
        </div>
</body>
</html>