<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- <html lang="en"> -->
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
      .nav_btn_container{
        display: flex;
        /* overflow-x: auto; 當內容超出寬度時出現橫向捲軸 */
        white-space: nowrap; /* 防止換行 */
      }

      div.login_container{
        /* border: 1px solid blue; */
        border-radius: 40px;
        width: 360px;
        margin: 0 auto;
        background-color: rgb(225, 213, 231);
        padding: 20px;
        box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.15);
      }

      div.login_title{
        /* border: 1px solid red; */
        justify-content: center;
        align-items: center;
        color: #7d2da3;
      }

      .cntn_text{
        display: block;
        color: #290738;
        font-size: 22px;
        font-weight: bold;
        margin-top: 1.5em;
        margin-bottom: 14px;
        /* unicode-bidi: isolate; */
      }

      /* div#search-btn{ */
        /* border: 1px solid red; */
      /* } */
      
      div.login_forget{
        display: flex;
        justify-content: space-evenly;
        
      }
      
      button.login_forget{
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
        width: 130px;
        background-color:rgb(212, 177, 207);
        border: 0;
        cursor: pointer;
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
      
      <a class="logo_homepage" href="/CIA103G5/frontend/member/homepage.jsp"><h1>修卜人生</h1></a>

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

     <jsp:useBean id="member" scope="session" class="com.cia103g5.mem.model.Member_info" />
<%--         <jsp:setProperty name="member" property="account" param="account"/> --%>
<%--         <jsp:setProperty name="member" property="password" param="password"/> --%>
<%--     </jsp:useBean> --%>
    
    <main>
      <div class="login_container">

        <div class="login_title">
          <h1>登入會員</h1>
        </div>

        <form action="LoginServlet" method="post">
          <label for="account" class="cntn_text">帳號</label>
          <input type="text" id="account" name="account" value="${member.account}" style="font-size:x-large;" required
                pattern="^[A-Za-z0-9]{6,20}$"
                title="帳號必須是 6 到 20 個字元，只能包含字母、數字">

          <label for="pswd" class="cntn_text">密碼</label>
          <input type="password" id="pswd" name="password" value="${member.password}" style="font-size:x-large;"/>

          <div class="login_forget">
            <div>
              <button class="login_forget">忘記密碼</button>
            </div>
            <div >
              <button type="submit" class="login_forget login" >登入</button>
            </div>
          </div>
        </form>

      </div>
    </main>
    
  </body>
</html>