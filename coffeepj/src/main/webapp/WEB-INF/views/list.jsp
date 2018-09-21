<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Coffee에 오신 것을 환영합니다</title>
</head>
<body>
	<h1>커피리스트 조회</h1>
	<button type="button" onclick="location.href='./add' ">새로운 커피 등록</button>
	<p id="table_here"></p>

	  <script>
   var shop_list="";
   
   window.onload = function () {
	   var txt="";
	   var values = [];
       $.ajax({
           url: "/getdata",
           type: "GET",
           async: false,
           dataType:'json',
           success: function (data) {	
          	 txt += "<table border='1'>"
          	 +"<thead>"
          	 +"<tr><th>이름</th>"
    		 +"<th>등록일</th>"
    		 +"<th>shop리스트</th>"
    		 +"<th>-</th>"
    		 +"</tr></thead><tbody>";
              $.each(data, function( index, value ) {
            	 txt+="<tr><td>"+ value.name + "</td>";
            	 txt+="<td>"+ value.regdate + "</td>";
            	 getShopData(value.id);
            	 txt+="<td>"+ shop_list + "</td>";
            	 txt+="<td><a href=\"./detail/"+value.id+"\">조회</a></td></tr>";
              });
              txt += "</table>" ;      
           }, error: function (jqXHR, textStatus, errorThrown) {
           },
           complete : function() {
        	   document.getElementById("table_here").innerHTML = txt; 
           }
      });
   }

   function getShopData(coffee_id){
	   shop_list="";
	   var id = coffee_id;
	    $.ajax({
	           url: "http://9.194.96.14:8090/getShopList/"+id, 
	           type: "GET",
	           crossOrigin: true,
	           async: false,
	           dataType:"json",
	           success: function (data) {	
	        	   console.log("id가"+id+"일 때"); 
	        	   $.each(data, function( index, value ) {
	        		    console.log("each문"+index+": "+value.name);
	        		    shop_list+=value.name+", ";
	        	   });
	           }, error: function (request,status,error) {
	        	   console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	           },
	           complete : function() {
	        	   console.log("getShopData끝:"+shop_list);
	        	   return shop_list;
	           }
	      });   
	  
   }
   
   </script>
</body>
</html>
