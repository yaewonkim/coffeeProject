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
	  
   window.onload = function () {
	   var txt="";
	   var values = [];
       $.ajax({
           url: "/getdata",
           type: "GET",
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
            	 txt+="<tr><td>"+value.name + "</td>";
            	 txt+="<td>"+value.regdate + "</td>";
            	 txt+="<td>"+"리스트채워라" + "</td>";
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
   </script>
</body>
</html>
