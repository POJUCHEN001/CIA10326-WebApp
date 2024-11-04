<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修卜人生FixLife</title>
    <link rel="stylesheet" href="./css/frame_home.css">
    <style>

      main{
        /* border: 2px solid red; */
        padding: 120px;
      }

      div.regist_container{
        /* border: 1px solid blue; */
        border-radius: 40px;
        width: auto;
        margin: 0 auto;
        background-color: rgb(225, 213, 231);
        padding: 20px;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.15);
      }

      div.regist_title{
        /* border: 1px solid red; */
        justify-content: center;
        align-items: center;
        color: #7d2da3;
        margin-bottom: auto;
      }
      .cntn_text{
        display: block;
        color: #290738;
        font-size: 1.17em;
        font-weight: bold;
        margin-top: 1.5em;
        margin-bottom: 14px;
        /* unicode-bidi: isolate; */
      }

      div.send_regist{
        /* border: 1px solid green; */
        /* display: flex; */
        justify-items: center;
      }
      div#search-btn{
        border: 1px solid red;
      }
       button.regist{
         /* padding: 10px 24px; */
        color: #7d2da3;
        border-radius: 10px;
        margin-top: 20px;
        padding: 10px 30px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        font-weight: bold;
        width: 250px;
        background-color:rgb(212, 177, 207);
        border: 0;
        cursor: pointer;
       }

       input, select{
        font-size: large;
        /* width: 100%; */
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
       }


    </style>
  </head>
  <body>

    <header>
      
      <div class="top-btn">
        <a href="homepage.jsp" class="top-btn">回首頁</a>
        <a href="homepage.jsp"><button class="top-btn">回首頁</button></a>
        <a href="regist.jsp"><button class="top-btn">註冊會員</button></a>
        <a href="login.jsp"><button class="top-btn">會員登入</button></a>
        <a href="membercenter.jsp"><button class="top-btn">會員中心</button></a>
        <button class="top-btn">通知</button>
        <button class="top-btn">客服中心</button>
      </div>
      
      <a class="logo_homepage" href="homepage.jsp"><h1>修卜人生</h1></a>

      <nav>
          <div id="search-container">
              <input type="text" id="search-bar" placeholder="搜尋文章">
              <button id="search-btn"><img src="./svg/magnifying-glass-solid.svg" alt="搜尋"></button>
          </div>
          <div class="nav_btn_container">
            <button class="nav-btn">最新消息</button>
            <button class="nav-btn">想找占卜師</button>
            <button class="nav-btn">購物商城</button>
            <button class="nav-btn">占卜論壇</button>
            <button class="nav-btn">線上塔羅小遊戲</button>
          </div>
      </nav>

    </header>
  
    <main>
      
      <div class="regist_container">

        <div class="regist_title">
          <h1>填寫會員基本資料</h1>
        </div>
		
        <form action="RegisterServlet" method="post" enctype="multipart/form-data">
        
          <label for="account" class="cntn_text">會員帳號</label>
          <input type="text" id="account" name="account" required placeholder="請設置會員帳號">

          <label for="password" class="cntn_text">密碼</label>
          <input type="password" id="password" name="password" required placeholder="請設置密碼">

          <label for="name" class="cntn_text">姓名</label>
          <input type="text" id="name" name="name" required >

          <label for="email" class="cntn_text">電子信箱</label>
          <input type="email" id="email" name="email" required  placeholder="xxx@gmail.com">

          <label for="gender" class="cntn_text">性別</label>
          <select id="gender" name="gender" required>
              <option value="" disabled selected>請選擇</option>
              <option value="1">男</option>
              <option value="2">女</option>
              <option value="0" >不公開</option>
          </select>
          
          <label for="photo" class="cntn_text">上傳大頭照</label>
          <input type="file" id="photo" name="photo" accept="image/*" required>
		
          <button type="submit" class="regist" value="送出" >送出</button>
          
        </form>
        
      </div>
    </main>
    
  </body>
</html>