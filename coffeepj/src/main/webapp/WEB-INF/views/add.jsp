<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>커피등록화면</title>
</head>
<body>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<h1>커피 등록 화면</h1>

		<label>이름</label>  <input type="text" name="name" id="name"/><br><br>
		<label>가격</label>  <input type="text" name="price" id="price"/><br><br>
		<label>재고</label>  <input type="text" name="stock" id="stock"/><br><br>
		<input type="button" name="addCoffee" id="addCoffee" value="저장" onclick="addCoffee();"/>
		<button type="button" onclick="location.href='./list' ">취소</button>
		
 
	
	<script>
	
	  function addCoffee() {
      
      var modelObj = {
            name: $("#name").val(),
            price: $("#price").val(),
            stock: $("#stock").val()
      };
      
      console.log("post data:"+modelObj);      
      
       $.ajax({
               type: "POST",
               url: "/add",
               headers: {
                   "Content-Type": "application/json"
               },
               data: JSON.stringify(modelObj),
               success: function (data) {
                  console.log("POST API RESPONSE::"+data);
               },
               error: function (jqXHR, textStatus, errorThrown) {
               },
               complete : function() { 
            	   alert("해당 음료를 등록하였습니다.");
               	   location.href= "../list";
               }
           });
   }
	</script>
   
</body>
</html>
