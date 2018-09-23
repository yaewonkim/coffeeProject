<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>상세조회</title>
</head>
<body>
	<h1>상세 조회</h1>

		<label>이름</label>  <input type="text" name="name" id="name" readonly/><br><br>
		<label>가격</label>  <input type="text" name="price" id="price"readonly/><br><br>
		<label>재고</label>  <input type="text" name="stock" id="stock"readonly/><br><br>
		<label>총 판매량</label>  <input type="text" name="tot_sales_num" id="tot_sales_num"readonly/><br><br>
		<label>총 판매액</label>  <input type="text" name="tot_sales" id="tot_sales"readonly/><br><br>
		<label>등록일</label>  <input type="text" name="regdate" id="regdate"readonly/><br><br>
		<label>수정일</label>  <input type="text" name="editdate" id="editdate"readonly/><br><br>
		
		<button type="button" onclick="gotoModifyPage();">수정</button>
		<button type="button" onclick="deleteCheck();">삭제</button>
		<button type="button" onclick="location.href='../list'">되돌아가기</button>
		<br><br>
		<label><b><매장 리스트></b></label>
		<p id="shop_detail"></p>
	
	<script>
	
   var modify_id="";
	
   window.onload = function (){
	   
       $.ajax({
           url: window.location.pathname+"/getdata",  
           type: "GET",
           dataType:'json',
           success: function (data) {	
        	   modify_id=data.id;
        	   document.getElementById("name").value = data.name;
        	   document.getElementById("price").value = data.price;
        	   document.getElementById("stock").value = data.stock;
        	   document.getElementById("tot_sales_num").value = data.salesnum;
        	   document.getElementById("tot_sales").value = (data.salesnum)*(data.price);
        	   document.getElementById("regdate").value = data.regdate;
        	   document.getElementById("editdate").value = data.editdate;
        	   
        	   getShopDetail(data.id);
           }, error: function (jqXHR, textStatus, errorThrown) {
           }
      });
   }
   
   //수정 클릭시 페이지 이동
   function gotoModifyPage(){ 
   	   console.log("mod_id:"+modify_id);
	   location.href= "./mod/"+modify_id;
   }
   

   function deleteCheck(){ 
	   if (confirm("정말 삭제 하시겠습니까?")){ 
	  	 delCoffee();
	   }else{ 
	   alert("삭제 취소 되었습니다."); 
	   location.href= "../list";
	   return; 
	   } 
	} 

   
   function delCoffee() {
	   addGarbage();
	   notifyShopMenuDeleted();
	   console.log("url:"+window.location.pathname+"/delCoffee");
       $.ajax({
    	   url: window.location.pathname+"/delCoffee",
           type: "POST",
           dataType:'json',
           success: function () {	
        	  
           }, error: function (jqXHR, textStatus, errorThrown) {
           },
           complete : function() { 
        	   alert("해당 음료를 삭제하였습니다.");
           	   location.href= "../list";
           }
      });
   }
   
  function addGarbage(){
	  var modelObj = {
	            name: $("#name").val(),
	            tot_sales_num: $("#tot_sales_num").val(),
	            tot_sales: $("#tot_sales").val()
	      };
	      
	      console.log("post data:"+modelObj);      
	      
	       $.ajax({
	               type: "POST",
	               url: "/addGarbage",
	               headers: {
	                   "Content-Type": "application/json"
	               },
	               data: JSON.stringify(modelObj),
	               success: function () {
	                  console.log("add Garbage success");
	               },
	               error: function (jqXHR, textStatus, errorThrown) {
	               }
	           });
  }
  
  //Shop Server에게 해당 Menu가 삭제되었음을 알림
  function notifyShopMenuDeleted(){

	       $.ajax({
	    	  	    url: "http://9.194.96.14:8090" + window.location.pathname + "/delCoffee",
	           	    type: "POST",
	           		dataType:'json',
	               success: function () {
	                  console.log("CORS_Shop에게 menu삭제 요청 성공");
	               },
	               error: function (jqXHR, textStatus, errorThrown) {
	               }
	           });
  }
  
  //Shop Server에게 해당 Menu파는 Shop상세정보 요청
  function getShopDetail(coffee_id){     //Coffee를 판매하는 Shop 상세 정보
	  var txt="";
	    $.ajax({
	    	   url: "http://9.194.96.14:8090/getShopList/"+coffee_id, 
	           type: "GET",
	           crossOrigin: true,
	           dataType:"json",
	           success: function (data) {	
	        	   $.each(data, function( index, value ) {
	        		 txt+="<b>매장명: "+ value.name + "</b><br>";
	              	 txt+="등록일: " + value.regdate + "<br>";
	              	 txt+="총 판매량: " + value.tot_sales_num + "<br>";
	              	 txt+="총 판매액: " + value.tot_sales + "<br>";
	              	 txt+="수정일: " + value.editdate +"<br><br>";
	                });
	           }, error: function (request,status,error) {
	        	   console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	           },
	           complete : function() {
	        	   document.getElementById("shop_detail").innerHTML = txt; 
	           }
	      });   
  }
   </script>
</body>
</html>


