<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Coffee에 오신 것을 환영합니다</title>
</head>
<body>
	<h1>test임</h1>


	  <script>
	  
	   window.onload = function (){  //해당 객체 받아와 input값 채우기
	       $.ajax({
	           url: "http://9.194.96.14:8090/getShopList",
	           type: "GET",
	           crossOrigin: true,
	           dataType:"text",
	           success: function (data) {	
	        	  console.log(data);
	           }, error: function (request,status,error) {
	        	   console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	           }
	      });
	   }
	   
   </script>
</body>
</html>
