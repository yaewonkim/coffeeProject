<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>수정하기</title>
</head>
<body>
	<h1>수정 하기</h1>

		<label>이름</label>  <input type="text" name="name" id="name"/><br><br>
		<label>가격</label>  <input type="text" name="price" id="price"/><br><br>
		<label>재고</label>  <input type="text" name="stock" id="stock"/><br><br>
		
		<input type="button" name="postmodData" id="postmodData" value="확인" onclick="postmodData();"/>
		<button type="button" onclick="location.href='../../list'">취소</button>
		
 
	
	<script>
	
   var modifying_id = "";
   window.onload = function (){  //해당 객체 받아와 input값 채우기
       $.ajax({
           url: window.location.pathname+"/getdata",
           type: "GET",
           dataType:'json',
           success: function (data) {	
        	   modifying_id = data.id;
        	   document.getElementById("name").value =data.name;
        	   document.getElementById("price").value =data.price;
        	   document.getElementById("stock").value =data.stock;
           }, error: function (jqXHR, textStatus, errorThrown) {
           }
      });
   }
   
	  function postmodData() { //수정된 커피 추가하기.
      
      var modelObj = {
            name: $("#name").val(),
            price: $("#price").val(),
            stock: $("#stock").val(),
            id : modifying_id
      };
	  
      if (confirm("해당 정보가 맞습니까?"+
    		  "\n\r이름:"+$("#name").val()+
    		  "\n\r가격:"+$("#price").val()+
    		  "\n\r재고:"+$("#stock").val())) {  
		   
      console.log("post data:"+modelObj);      
      console.log("수정하는 coffee_id: "+modifying_id);
      
       $.ajax({
               type: "POST",
               url: "/detail/mod/confirm", 
               headers: {
                   "Content-Type": "application/json"
               },
               data: JSON.stringify(modelObj),
               success: function (data) {
                  console.log("POST API RESPONSE::"+data.name+" "+data.price+" "+data.stock);
               },
               error: function (jqXHR, textStatus, errorThrown) {
               },
               complete : function() { 
            	   alert("해당 음료를 수정하였습니다.");
               	   location.href= "../../list";
               }
           });
      } else { 
		   alert("수정 취소 되었습니다."); 
		   location.href= "../../list";
		   return; 
	  } 
     
   }
	  
	</script>

</body>
</html>


