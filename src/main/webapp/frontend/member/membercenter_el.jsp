<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- <html lang="en"> -->
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>

      *{
        box-sizing: border-box;
      }

      body{
        margin: 0;
      }

      header {
        background-color: #7d2da3;
        color: white;
        padding: 10px;
        text-align: left;
        height: 160px;
      }

      a.logo_homepage{
        color: white;
        text-decoration: none;
      }

      h1 {
        /* border: 1px solid red; */
        margin: 0;
        font-size: 40px;
        text-align: left;  /* 設置文字靠左 */
        padding-left: 10px;  /* 根據需求調整左側的間距 */
      }

      div.top-btn{  /*登入註冊列*/
        /* border: 1px solid red; */
        text-align: right;
      }

      nav { 
        margin-top: 10px;
        display: flex; 
        /* justify-content: space-between; */
        justify-content: left;
        align-items: center;  
      }
      #search-container {
        position: relative;  /* 搜尋區容器，設置相對定位 */
        width: 300px;
      }
      #search-bar {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
      }

      #search-btn {
        position: absolute;  /* 絕對定位，將按鈕放置在輸入框內 */
        right: 5px;  /* 靠右對齊，與右邊框有 5px 的距離 */
        top: 50%;
        transform: translateY(-50%);  /* 確保按鈕垂直居中 */
        border: none;
        background: transparent;
        cursor: pointer;
      }

      #search-btn img {
        width: 20px;
        height: 20px;
      }

      .nav-btn {
        border: none;
        padding: 10px 15px;
        margin: 5px;
        background-color: white;
        /* border: 2px solid #333; */
        cursor: pointer;
        font-size: 14px;
        display: inline-block;  /* 保持按鈕並排 */
      }

      main{
        /* border: 2px solid red; */
        padding: 120px;
        flex-direction: column;
        display: flexbox;
      }

      div.container{
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

       aside {
        width: 20%;
        padding-left: 15px;
        /* margin-left: 15px; */
        float: left;
        font-style: italic;
        background-color: lightgray;
        display:block;
        height: calc(100vh - 160px); /* 減去 header 高度 */
        /* overflow-y: auto; 如內容超出視窗高度，會自動顯示滾動條 */
      }
      a.aside{
        padding: 15px;
        display:block;
      }

      div.aside{
        margin-top: 30px;
      }
       .container img{
        width: 150px;
        height: 150px;
      }
      
      div.mem_center{
        display: flex;
        /* justify-content: space-around; 兩個 div 水平排列並對齊 */
        align-items: flex-start; /* 對齊頂部 */
        text-align: left;
      }

      div.mem_photo{
        text-align: left;
        margin-right: 50px;
      }

    </style>
  
  </head>
  <body>

    <header>
      <div class="top-btn">
          <a href="regist.jsp"><button class="top-btn">註冊會員</button></a>
          <a href="login.jsp"><button class="top-btn">會員登入</button></a>
          <button class="top-btn">會員中心</button>
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
  
    <aside>
      <div class="aside">
        <a href="" class="aside">會員基本資料</a>
        <br>
        <a href="" class="aside">查詢訂單</a>
        <br>
        <a href="" class="aside">查詢預約</a>
        <br>
        <a href="" class="aside">查詢收藏商品</a>
        <br>
        <a href="" class="aside">查詢收藏占卜師</a>
      </div>
    </aside>

    <main>
      <jsp:useBean id="member" scope="session" class="com.cia103g5.mem.model.Member_info" />
      
      <div class="container">
           <h2>會員基本資料</h2>
          <div class="mem_center">
            <div class="mem_photo">
              <img src="data:image/*;base64,${photo}" alt="會員大頭照" style="width:100px; height:100px;">
              <br>
              <button>更換照片</button>
            </div>
             <div class="mem_info">
          <table>
              <tr>
                  <td>會員編號：</td>
                  <td>${member.mem_id}</td>
              </tr>
              <tr>
                  <td>姓名：</td>
                  <td>${member.name}</td>
              </tr>
              <tr>
                  <td>暱稱：</td>
                  <td>${member.nickname}</td>
              </tr>
              <tr>
                  <td>性別：</td>
                  <td>${member.gender}</td>
              </tr>
              <tr>
                  <td>會員帳號：</td>
                  <td>${member.account}</td>
              </tr>
              <tr>
                  <td>會員密碼：</td>
                  <td>********</td>
              </tr>
              <tr>
                  <td>電子信箱：</td>
                  <td>${member.email}</td>
              </tr>
              <tr>
                  <td>驗證email狀態：</td>
                  <td>${member.email_state}</td>
              </tr>
              <tr>
                  <td>會員註冊時間：</td>
                  <td>${member.registered_at}</td>
              </tr>
              <tr>
                  <td>總積分：</td>
                  <td>${member.points}</td>
              </tr>
          </table>
	
        </div>
      </div>
    </main>
    
  </body>
</html>