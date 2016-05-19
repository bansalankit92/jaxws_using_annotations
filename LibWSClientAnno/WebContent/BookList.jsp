<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Detail & List</title>
</head>
<body align="center">
<br><br>
<a href="addBook.jsp">Add Book To DB</a>
<br><br>
<h2>All Book Lists</h2>
<button id="btnBookList" type="submit" value="submit">Get Full List</button>
<p id="pbookList"></p>

<table border="1" align="center" id="tbl_booklist">
<thead>
<tr>
<td> </td>
</tr>
</thead>
<tbody>
<tr></tr>

</tbody>
</table>



<br><br>

<h2>Book details By ID</h2>
<form action="javascript:return(void)">
<input type="text" name="id" id="bookID" placeholder="Book ID or Name" required>
<button id="bookId" type="submit" value="submit">Get Book</button>


</form>

<br/><br/>

<p id="bookName"></p>


<table border="1" align="center" id="tbl_bookDet">
<thead>
<tr>
<td> </td>
</tr>
</thead>
<tbody>
<tr></tr>

</tbody>
</table>



<script type="text/javascript">
$(document).ready(function () {
	$('#tbl_bookDet').hide();
			$('#tbl_booklist').hide();

});



$("#bookId").click(function(){
	//alert(54);
    	var id=$("#bookID").val();
    	if(id==''){}
    	else{
    	url="http://localhost:8082/LibWSClientAnno/BookDetails?id="+id;
	  	  xmlhttpreq = new XMLHttpRequest();
	xmlhttpreq.open("POST", url, true);

	xmlhttpreq.onreadystatechange = fetchResponseiAjaxGetBook;



	xmlhttpreq.send("");
    	}

});
 function fetchResponseiAjaxGetBook(){
	
 	if(xmlhttpreq.readyState==4 && xmlhttpreq.status==200){
 		
 		var str=xmlhttpreq.responseText;
 		// var str = "2,java4,gosling4,2200.5,432qwe78946: 4,Oracle,steve,1035.0,null: 5,Oracle sql,steve o,105.0,wer34487:";
 		
 		if(str.toString()==null){
 			
 			$("#bookName").html("No Book found!!");
 		
 		}else{
 		$('#tbl_bookDet tbody tr').remove();
 		$('#tbl_bookDet').show();

		 			
		
		 document.getElementById("tbl_bookDet").innerHTML= 
		        " <thead>"
         +    " <tr>"
         +    " <th>ID</th>"
         +    " <th>Name</th>"
         +    " <th>author</th>"          
         +    " <th>price</th>"
         +    " <th>ISBN No.</th>"
         +    " </tr></thead>";
		 
		  	
 			var res1=str.split(",");
 			var table = document.getElementById("tbl_bookDet");
 			var row = table.insertRow(1);
 			
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			
			cell1.innerHTML = res1[0];
			if( res1[0].toString()=='no_book')
	 			$("#bookName").html("No Book found!!");
			cell2.innerHTML = res1[1];
			cell3.innerHTML = res1[2];
			cell4.innerHTML = res1[3];
			cell5.innerHTML = res1[4];
 	    //document.getElementById("demo").innerHTML = res1[1]; 
			
 	}
 	
 		
 	}
 	
 		//alert(msg);
			
 	return false;
	}
 
 
 
 
 $("#btnBookList").click(function(){
		//alert(54);
	    	var id=$("#bookID").val();
	    	url="http://localhost:8082/LibWSClientAnno/BooksList";
		  	  xmlhttpreq1 = new XMLHttpRequest();
		xmlhttpreq1.open("POST", url, true);
		xmlhttpreq1.onreadystatechange = fetchResponseiAjaxBooklist;
		xmlhttpreq1.send("");	

	});
 
 function fetchResponseiAjaxBooklist(){
		
	 	if(xmlhttpreq1.readyState==4 && xmlhttpreq1.status==200){
 
	 		//$("#pbookList").html(xmlhttpreq1.responseText);
	 		
	 		var str=xmlhttpreq1.responseText;
	 		// var str = "2,java4,gosling4,2200.5,432qwe78946: 4,Oracle,steve,1035.0,null: 5,Oracle sql,steve o,105.0,wer34487:";
	 		 $('#tbl_booklist').show();
	 		$('#tbl_booklist tbody tr').remove();
			
			 var count = 1;							
			
			 document.getElementById("tbl_booklist").innerHTML= 
			        " <thead>"
	         +    " <tr>"
	         +    " <th>ID</th>"
	         +    " <th>Name</th>"
	         +    " <th>author</th>"          
	         +    " <th>price</th>"
	         +    " <th>ISBN No.</th>"
	         +    " </tr></thead>";
			 
			  var count=1;
	 		 
	 	    var res = str.split(":");
	 	    for(var i=0;i<(res.length)-1;i++){
	 	    	
	 			var res1=res[i].split(",");
	 			
	 			
	 			var table = document.getElementById("tbl_booklist");
				var row = table.insertRow(count++);
				row.id=count;
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				
				cell1.innerHTML = res1[0];
				cell2.innerHTML = res1[1];
				cell3.innerHTML = res1[2];
				cell4.innerHTML = res1[3];
				cell5.innerHTML = res1[4];
	 	    //document.getElementById("demo").innerHTML = res1[1]; 
	 	}
	 	}
	 		//alert(msg);
				
	 	return false;
		}
 
 
 
 
</script>



</body>
</html>