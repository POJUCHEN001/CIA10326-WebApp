<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fix Life</title>
<link rel="stylesheet" href="./css/frame_home.css">
<style>
main {
	/* border: 2px solid red; */
	padding: 120px;
}

.homepicture {
	/* border: 2px solid black; */
	display: flex;
	/* align-items: center; */
	justify-content: center;
	position: relative;
	/* width: 50%; */
}

.homepicture img {
	width: 600px;
	height: 550px;
}

.caption {
	/* opacity= 0; */
	position: absolute;
	top: 0;
	background: rgba(97, 35, 97, 0.7);
	padding: 80px;
	color: white;
	width: 600px;
	height: 100%;
}
</style>
</head>

<body>
    <header>
      
      <div class="top-btn">
          <a href="homepage.jsp"><button class="top-btn">回首頁</button></a>
          <a href="regist.jsp"><button class="top-btn">註冊會員</button></a>
          <a href="login.jsp"><button class="top-btn">會員登入</button></a>
          <a href="membercenter.jsp"><button class="top-btn">會員中心</button></a>
          <button class="top-btn">通知</button>
          <button class="top-btn">客服中心</button>
      </div>
  
      <a herf="homepage.html"><h1>修卜人生</h1></a>
      <nav>
          <div id="search-container">
              <input type="text" id="search-bar" placeholder="搜尋文章">
              <button id="search-btn"><img src="img/search-icon.png" alt="搜尋"></button>
          </div>
          <button class="nav-btn">最新消息</button>
          <button class="nav-btn">想找占卜師</button>
          <button class="nav-btn">購物商城</button>
          <button class="nav-btn">占卜論壇</button>
          <button class="nav-btn">線上塔羅小遊戲</button>
      </nav>
    </header>
    <main>
      <div class="homepicture">
        <img src="./img/fixlife.webp">
        <div class="caption">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit.Labore, assumendo?
        </div>
      </div>
    </main>

    <script src="./vendors/jquery/jquery-3.7.1.min.js"></script>
    
    <script>

      //  首圖效果
      $('.homepicture').mouseenter(function(e){
        $(this).find('.caption').animate({'opacity': 1});
      });

      $('.homepicture').mouseout(function(e){
        $(this).find('.caption').animate({'opacity': 0});
      });
    </script>
  </body>
</html>