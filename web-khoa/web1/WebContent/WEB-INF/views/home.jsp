<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truyenhay.vn</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="stylesheet" href="./asset/css/main.css">
<link rel="stylesheet" href="./asset/css/base.css">
<link rel="stylesheet" href="./asset/fonts/fontawesome-free-5.15.1-web/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&family=Source+Sans+Pro:wght@300;600&display=swap" rel="stylesheet">
</head>
<body>
	<div class="app">
            <header class="header">
                <div class="grid"> 
                    <nav class="header__navbar">
                        <ul class="header__navbar-list">
                            <img class="header__navbar--logo" src="./asset/img/logo.png" alt="Logo">
                            <div class="header__item">
                                <li class="color header__item danhmuc_list"><span class="item" style="width:50%">
                                    <i class="fas fa-align-justify" ></i>
                                    Danh mục</span>
                                    <div class="danhmuc-theloai">
                                        <header class="header_danhmuc">
                                                <ul class="danhmuc-list">
                                                    <li class="item_dm"><a href="theloai_truyenmoi" class="item_loaidanhmuc">Truyện mới</a></li>
                                                    <li class="item_dm"><a href="theloai_truyenhoanthanh" class="item_loaidanhmuc">Truyện hoàn thành</a></li>
                                                    <li class="item_dm"><a href="theloai_truyenuathich" class="item_loaidanhmuc">Truyện ưa thích</a></li>
                                                </ul>
                                        </header>
                                    </div>
                                </li>   
                            </div> 
                        </ul>
                        <ul class="header__login-search">
                                <li class="header__item-login">
                                    <a href="" class="item dangnhaptaikhoan" onclick="login()">
                                    
                                    	<span>
                                        	<i class="far fa-user-circle"></i>
                                        	<c:forEach items="${user}" var="user1">
                                        	${user1.hoten}</c:forEach>
                                        </span>
                                     
                                    </a></li>
                                <span class="header__item-login vach">|</span>
                                <li class="header__item-login"><a href="logout"class="item dangkytaikhoan"><span style="width : 100%;" >Thoát</span></a></li>
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
                                <img src="https://static.cdnno.com/poster/chu-gioi-tan-the-online/300.jpg?1585206156" alt="" class="top1thinhhanh">
                                </div>
                                <h2 class ="btv_decu-tua">Chư giới tận thế Online</h2>
                                <span class="btv_decu-chitiet">
                                    Tận thế của chư giới đã tới.

									Ma Vương Trật Tự thu gặt lấy từng mạng sống của chúng sinh.
									
									Ở trong bóng tối đầy tuyệt vọng này,
									
									Có một người tránh thoát thời không, trở lại thế giới sụp đổ trước đó, quyết tâm cải biến vận mệnh trong quá khứ.
									
									Nhưng theo thời gian dần dần trôi qua, hắn dần dần phát hiện rằng tận thế cũng không phải là đơn giản như vậy...
                                </span>
                            </div>
                             <div class="header-topthinhhanh">
                                <span class="header-title">Thư viện</span>
                                <div class="header-topthinhhanh-list">
                                	<table border="1" cellpadding="5" cellspacing="1", style="width: 100%;border: 0px;">
                                        <c:forEach items="${sachList}" var="sach">
                                        <tr class="sach-item">
                                            <td  style="height: 75px;width: 13%; border: 0px;"><div class="header-topthinhhanh-item"><a href="${sach.chitiet}" class="header-topthinhhanh-item-link"><img src="${sach.linkbia}" alt="" class="anhkia-sach" style="border: 0px;"></a></div></td>
                                            <td  style="height: 75px;width: 80%; border: 0px;"><div class="header-topthinhhanh-item"><a href="${sach.chitiet}" class="header-topthinhhanh-item-link"><span class="tensach sach-hover" >${sach.tensach}</span></a></div></td>
                                           <!-- <td  style="height: 75px;width: 5%; border: 0px;"><div class="header-topthinhhanh-item"><a href="${sach.chitiet}" class="header-topthinhhanh-item-link"><span class="tensach sach-hover" >${sach.chitiet}</span></a></div></td>-->
                                            </tr>
                                        </c:forEach>
                                    </table>
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