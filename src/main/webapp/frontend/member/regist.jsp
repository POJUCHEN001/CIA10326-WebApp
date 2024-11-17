<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FixLife</title>
    <link rel="stylesheet" href="./css/frame_home.css">
    <style>

      main{
        /* border: 2px solid red; */
        padding: 120px;
      }

      div.regist_container{
        /* border: 1px solid blue; */
        border-radius: 40px;
        width: 360px;
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
       /* 錯誤訊息樣式 */
      .error-message {
          color: red;
          font-size: 1em;
          font-weight: bold;
          margin-bottom: 20px;
          text-align: center;
      }

    </style>
  </head>
  <body>

    <header>
     
      <div class="top-btn">
          <a href="homepage.jsp"><button class="top-btn">回首頁</button></a>
          <button class="top-btn">註冊會員</button>
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
          <button class="nav-btn">最新消息</button>
          <button class="nav-btn">想找占卜師</button>
          <button class="nav-btn">購物商城</button>
          <button class="nav-btn">占卜論壇</button>
          <button class="nav-btn">線上塔羅小遊戲</button>
      </nav>

    </header>
  
    <main>
      
      <div class="regist_container">

		<!-- 錯誤訊息顯示區 -->
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        
        <div class="regist_title">
          <h1>註冊會員</h1>
        </div>

        <div class="send_regist">
          <div class="reg_member">
            <a href="regist_member.jsp">
              <button class="regist" >註冊一般會員</button>
            </a>
          </div>
  
          <div class="reg_ft">
            <a href="regist_ftmember.jsp">
            <button class="regist">註冊占卜師會員</button>
            </a>
          </div>

        </div>
        
      </div>
    </main>
    
  </body>
</html>