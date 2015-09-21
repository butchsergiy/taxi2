
var ordersArray = new Array();

function Order(id,dateAndTime,addr1,addr2,addr34, distance, orderCost, customerPhone, customerName, carNumber,carDriver,isDone){
   this.id = id;
   this.dateAndTime = dateAndTime;
   this.addr1 = addr1;
   this.addr2 = addr2;  
   this.addr34 = addr34;        
   this.distance = distance;    
   this.orderCost = orderCost;
   this.customerPhone = customerPhone;
   this.customerName = customerName;
   this.carNumber = carNumber;
   this.carDriver = carDriver;  
   this.isDone = isDone;
};

// Waiting until DOM is ready
$(document).ready(onReady);
      
        
function onReady(){
//	loadInitData();    

	$("#RefreshOrders").click(function(event){
		Show();
		Show();
		});


	// Validating NOT DONE
	// Selecting the form and defining validation method
    $("#tab-1b").validate({
        // Passing the object with custom rules
        rules : {
            // login - is the name of an input in the form
            login : {
              // Setting login to be required
              required : true
            },
            email : {
                required : true,
                // Setting email pattern for email input
                email : true
            },
            password : {
                required : true,
                // Setting minimum and maximum lengths of a password
                minlength : 5,
                maxlength : 8
            },
            
            addr1 : {
				required : true
            }
            
        },
        // Setting error messages for the fields
        messages: {
            login: "Enter you login",
            password: {
                required: "Enter your password",
                minlength: "Minimum password length is 5",
                maxlength: "Maximum password length is 8"
            },
            email: "Enter you email",
            addr1 : "enter addr1"
        },
        // Setting submit handler for the form
        submitHandler: function(form) {
            form.submit();
        }
    });






	

};


function loadInitData0(){
    $.ajax({
            type: "GET",
            contentType:"application/json",
            url: "rest/taxiservice/orders",
            dataType: 'json',
            cache: false,
            success: function (data, textStatus, xhr) {
                   ordersArray = $.map(data, function(el) { return el; });
            },
            error: function (data, textStatus, errorThrown) {
                    console.log(textStatus)
            }
         });
 };

 function loadInitData1(){
     $.ajax({
             type: "POST",
             contentType:"application/json",
             url: "rest/taxiservice/orders",
             dataType: 'json',
             cache: false,
             success: function (data, textStatus, xhr) {
                    ordersArray = $.map(data, function(el) { return el; });
             },
             error: function (data, textStatus, errorThrown) {
                     console.log(textStatus)
             }
          });
  };
 
 function loadInitData(){
 	$.get("rest/taxiservice/orders", function(data, status){
 		ordersArray = $.map(data, function(el) { return el; });
     });
    

	};



        function Show(){
		  var listTableBody = $("#listTableBody");
          listTableBody.empty();
               
              for(i=0; i<ordersArray.length; i++){
              order = ordersArray[i];
				var row = $("<tr><\/tr>");
				var id = $("<td>"+order.id+"<\/td>");
				var dateAndTime = $("<td>"+order.dateAndTime+"<\/td>");  
				var addr1 = $("<td>"+order.addr1+"<\/td>");
				var addr2 = $("<td>"+order.addr2+"<\/td>");
				var addr34 = $("<td>"+order.addr34+"<\/td>");
				var distance = $("<td>"+order.distance+"<\/td>");
				var orderCost = $("<td>"+order.orderCost+"<\/td>");
				var customerPhone = $("<td>"+order.customerPhone+"<\/td>");
				var customerName = $("<td>"+order.customerName+"<\/td>");
				var carNumber = $("<td>"+order.carNumber+"<\/td>");
				var carDriver = $("<td>"+order.carDriver+"<\/td>");
				var isDone = $("<td>"+order.isDone+"<\/td>");
				var op = $("<td><img src='delete.png' class='btnDelete'/> <img src='edit.png' class='btnEdit' title='EDIT'><\/td>");
              
				id.appendTo(row);
				dateAndTime.appendTo(row);
				addr1.appendTo(row);
				addr2.appendTo(row);
				addr34.appendTo(row);
				distance.appendTo(row);
				orderCost.appendTo(row);
				customerPhone.appendTo(row);
				customerName.appendTo(row);
				carNumber.appendTo(row);
				carDriver.appendTo(row);
				isDone.appendTo(row);
				op.appendTo(row);
                                 
              row.appendTo(listTableBody);
			}
			$("#OrdersList").show();  
			$(".btnEdit").bind("click", Edit);		
			$(".btnDelete").bind("click", Delete);
        };
        

        
        
        
        function Create(){
                var id = "0";
                var dateAndTime = "0";
                var addr1 = $("#createAddr1").val();
                var addr2 = $("#createAddr2").val();
                var addr34 = $("#createAddr34").val();
                var distance = $("#createDistance").val();
                var orderCost = $("#createOrderCost").val();
                var customerPhone = $("#createCustomerPhone").val();
                var customerName = $("#createCustomerName").val();
                var carNumber = $("#createCarNumber").val();
                var carDriver = $("#createCarDriver").val();
                var isDone = "";
                var data1 = formToData(id,dateAndTime,addr1,addr2,addr34,distance,orderCost,customerPhone,customerName,carNumber, carDriver,isDone );
                console.log(data1);
                
                $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url: "rest/taxiservice/orderc",
                        dataType:'json',
                        data:data1,
                        
                        success: function (data, textStatus, xhr) {
                                console.log(textStatus);
                                alert(textStatus);
                        },
                        error: function (data1, textStatus, errorThrown) {
                                console.log(textStatus);
                                alert(data1.responseText);      
                                                                
                        }
                });

        };               
        





        
           
        function formToData(id,dateAndTime,addr1,addr2,addr34,distance,orderCost,customerPhone,customerName,carNumber,carDriver,isDone){
          return JSON.stringify({
                  "id":id,
                  "dateAndTime":dateAndTime,
                  "addr1":addr1,
                  "addr2":addr2,
                  "addr34":addr34,
                  "distance":distance,
                  "orderCost":orderCost,
                  "customerPhone":customerPhone,
                  "customerName":customerName,
                  "carNumber":carNumber,
                  "carDriver":carDriver,
                  "isDone":isDone                         
                });
        };

		function AddRow(){
			var listTableBody = $("#listTableBody");
			
			listTableBody.append(
			"<tr>"+
			"<td></td>"+
			"<td></td>"+
			"<td><input type='text' maxlength='40' required/></td>"+
			"<td><input type='text' maxlength='40'/></td>"+
			"<td><input type='text' maxlength='40'/></td>"+
			"<td><input type='number' size='4' maxlength='5' value='1'/></td>"+
			"<td><input type='number' size='4' maxlength='5' value='1'/></td>"+
			"<td><input type='text' size='9' maxlength='14'/></td>"+
			"<td><input type='text' size='9' maxlength='20'/></td>"+
			"<td><input type='text' size='8' maxlength='20'/></td>"+
			"<td><input type='text' size='9' maxlength='20'/></td>"+
			"<td><input type='text' size='4' maxlength='5' value='false'/></td>"+
			"<td><img src='delete.png' class='btnDelete'/><img src='save.png' class='btnSave' title='SAVE'></td>"+
			"</tr>");
			
		$("#OrdersList").show();  
		$(".btnEdit").bind("click", Edit);
		$(".btnDelete").bind("click", Delete);
		$(".btnSave").bind("click", Save);
		
		};
		
		
		function Save(){
			var par = $(this).parent().parent(); 
						
			var rid =  par.children("td:nth-child(1)");
			var rdateAndTime =  par.children("td:nth-child(2)");
			var raddr1 = par.children("td:nth-child(3)");
			var raddr2 = par.children("td:nth-child(4)");
			var raddr34 = par.children("td:nth-child(5)");
			var rdistance = par.children("td:nth-child(6)");
			var rorderCost = par.children("td:nth-child(7)");
			var rcustomerPhone = par.children("td:nth-child(8)");
			var rcustomerName = par.children("td:nth-child(9)");
			var rcarNumber = par.children("td:nth-child(10)");
			var rcarDriver = par.children("td:nth-child(11)");
			var risDone = par.children("td:nth-child(12)");
			var tdButtons = par.children("td:nth-child(13)");
		
			var id = rid.children("input[type=text]").val();
			var dateAndTime = rdateAndTime.children("input[type=text]").val();
			var addr1 = raddr1.children("input[type=text]").val();
			var addr2 = raddr2.children("input[type=text]").val();
			var addr34 = raddr34.children("input[type=text]").val();
			var distance = rdistance.children("input[type=number]").val();
			var orderCost = rorderCost.children("input[type=number]").val();
			var customerPhone = rcustomerPhone.children("input[type=text]").val();
			var customerName = rcustomerName.children("input[type=text]").val();
			var carNumber = rcarNumber.children("input[type=text]").val();
			var carDriver = rcarDriver.children("input[type=text]").val();
			var isDone = risDone.children("input[type=text]").val();

			rid.html(rid.children("input[type=text]").val());
			rdateAndTime.html(rdateAndTime.children("input[type=text]").val());
			raddr1.html(raddr1.children("input[type=text]").val());
			raddr2.html(raddr2.children("input[type=text]").val());
			raddr34.html(raddr34.children("input[type=text]").val());
			rdistance.html(rdistance.children("input[type=number]").val());
			rorderCost.html(rorderCost.children("input[type=number]").val());
			rcustomerPhone.html(rcustomerPhone.children("input[type=text]").val());
			rcustomerName.html(rcustomerName.children("input[type=text]").val());
			rcarNumber.html(rcarNumber.children("input[type=text]").val());
			rcarDriver.html(rcarDriver.children("input[type=text]").val());
			risDone.html(risDone.children("input[type=text]").val());
			tdButtons.html("<img src='delete.png' class='btnDelete'/><img src='edit.png' class='btnEdit' title='EDIT'/>");
				
			var data1 = formToData(id,dateAndTime,addr1,addr2,addr34,distance,orderCost,customerPhone,customerName,carNumber, carDriver,isDone );
                console.log(data1);
                
                $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url: "rest/taxiservice/orderc",
                        dataType:'json',
                        data:data1,
                        
                        success: function (data, textStatus, xhr) {
                                console.log(textStatus);
                                alert(textStatus);
                        },
                        error: function (data1, textStatus, errorThrown) {
                                console.log(textStatus);
                                alert(data1.responseText);
                        }
                });
						
			$(".btnEdit").bind("click", Edit);
			$(".btnDelete").bind("click", Delete);
		}; 
		
		
		function Delete(){
			var par = $(this).parent().parent(); 
			var rid =  par.children("td:nth-child(1)");
			rid.html("<input type='text' id='txtName' value='"+rid.html()+"'/>");
			var id = rid.children("input[type=text]").val();
			$.ajax({
				type: "POST",
				contentType:"application/json",
				url: "rest/taxiservice/orderd",
				dataType:'json',
				data:id,
				
				success: function (data, textStatus, xhr) {
						console.log(textStatus);
						alert(textStatus);
				},
				error: function (data1, textStatus, errorThrown) {
						console.log(textStatus);
						alert(data1.responseText);
				}
                });
			par.remove();
		};
		
		
		
		function Edit(){
			var par = $(this).parent().parent();
			
			var rid =  par.children("td:nth-child(1)");
			var rdateAndTime =  par.children("td:nth-child(2)");
			var raddr1 = par.children("td:nth-child(3)");
			var raddr2 = par.children("td:nth-child(4)");
			var raddr34 = par.children("td:nth-child(5)");
			var rdistance = par.children("td:nth-child(6)");
			var rorderCost = par.children("td:nth-child(7)");
			var rcustomerPhone = par.children("td:nth-child(8)");
			var rcustomerName = par.children("td:nth-child(9)");
			var rcarNumber = par.children("td:nth-child(10)");
			var rcarDriver = par.children("td:nth-child(11)");
			var risDone = par.children("td:nth-child(12)");
			var tdButtons = par.children("td:nth-child(13)");
			var risDoneOld=risDone.html();
			
			rid.html("<input type='text' size='4' maxlength='6' id='txtName' value='"+rid.html()+"'/>");
			rdateAndTime.html("<input type='text' maxlength='30' id='txtName' value='"+rdateAndTime.html()+"'/>");
			raddr1.html("<input type='text' maxlength='40' id='txtName' value='"+raddr1.html()+"'/>");
			raddr2.html("<input type='text' maxlength='40' id='txtPhone' value='"+raddr2.html()+"'/>");
			raddr34.html("<input type='text' maxlength='40' id='txtEmail' value='"+raddr34.html()+"'/>");
			rdistance.html("<input type='number' size='4' maxlength='5' id='txtName' value='"+rdistance.html()+"'/>");
			rorderCost.html("<input type='number' size='4' maxlength='5' id='txtName' value='"+rorderCost.html()+"'/>");
			rcustomerPhone.html("<input type='text' size='9' maxlength='14' id='txtName' value='"+rcustomerPhone.html()+"'/>");
			rcustomerName.html("<input type='text' size='9' maxlength='20' id='txtName' value='"+rcustomerName.html()+"'/>");
			rcarNumber.html("<input type='text' size='8' maxlength='20' id='txtName' value='"+rcarNumber.html()+"'/>");
			rcarDriver.html("<input type='text' size='9' maxlength='20' id='txtName' value='"+rcarDriver.html()+"'/>");
			risDone.html("<select id='isDoneSelect'><option value='false'>false</option><option value='true'>true</option></select>");
						$("#isDoneSelect").val(risDoneOld.valueOf());
			tdButtons.html("<img src='save.png' class='btnUpdate' title='UPDATE'/>");

			$(".btnUpdate").bind("click", UpdateOrder);

		};
		

		function UpdateOrder(){
			var par = $(this).parent().parent(); 
						
			var rid =  par.children("td:nth-child(1)");
			var rdateAndTime =  par.children("td:nth-child(2)");
			var raddr1 = par.children("td:nth-child(3)");
			var raddr2 = par.children("td:nth-child(4)");
			var raddr34 = par.children("td:nth-child(5)");
			var rdistance = par.children("td:nth-child(6)");
			var rorderCost = par.children("td:nth-child(7)");
			var rcustomerPhone = par.children("td:nth-child(8)");
			var rcustomerName = par.children("td:nth-child(9)");
			var rcarNumber = par.children("td:nth-child(10)");
			var rcarDriver = par.children("td:nth-child(11)");
			var risDone = par.children("td:nth-child(12)");
			var tdButtons = par.children("td:nth-child(13)");
		
			var id = rid.children("input[type=text]").val();
			var dateAndTime = rdateAndTime.children("input[type=text]").val();
			var addr1 = raddr1.children("input[type=text]").val();
			var addr2 = raddr2.children("input[type=text]").val();
			var addr34 = raddr34.children("input[type=text]").val();
			var distance = rdistance.children("input[type=number]").val();
			var orderCost = rorderCost.children("input[type=number]").val();
			var customerPhone = rcustomerPhone.children("input[type=text]").val();
			var customerName = rcustomerName.children("input[type=text]").val();
			var carNumber = rcarNumber.children("input[type=text]").val();
			var carDriver = rcarDriver.children("input[type=text]").val();
			var isDone = risDone.children("select").val();

			rid.html(rid.children("input[type=text]").val());
			rdateAndTime.html(rdateAndTime.children("input[type=text]").val());
			raddr1.html(raddr1.children("input[type=text]").val());
			raddr2.html(raddr2.children("input[type=text]").val());
			raddr34.html(raddr34.children("input[type=text]").val());
			rdistance.html(rdistance.children("input[type=number]").val());
			rorderCost.html(rorderCost.children("input[type=number]").val());
			rcustomerPhone.html(rcustomerPhone.children("input[type=text]").val());
			rcustomerName.html(rcustomerName.children("input[type=text]").val());
			rcarNumber.html(rcarNumber.children("input[type=text]").val());
			rcarDriver.html(rcarDriver.children("input[type=text]").val());
			risDone.html(risDone.children("select").val());
			tdButtons.html("<img src='delete.png' class='btnDelete'/><img src='edit.png' class='btnEdit'/>");
				
			var data1 = formToData(id,dateAndTime,addr1,addr2,addr34,distance,orderCost,customerPhone,customerName,carNumber, carDriver,isDone );
                console.log(data1);
                $.ajax({
                        type: "POST",
                        contentType:"application/json",
                        url: "rest/taxiservice/orderu",
                        dataType:'json',
                        data:data1,
                        
                        success: function (data, textStatus, xhr) {
                                console.log(textStatus);
                                alert(textStatus);
                        },
                        error: function (data1, textStatus, errorThrown) {
                                console.log(textStatus);
                                alert(data1.responseText);
                        }
                });
						
			$(".btnEdit").bind("click", Edit);
			$(".btnDelete").bind("click", Delete);
		}; 
		

		function sleep(miliseconds) {
	           var currentTime = new Date().getTime();
	           while (currentTime + miliseconds >= new Date().getTime()) {
	           }
	       };

		
		function LogIn(){
			var l = document.getElementById("login");
			var p = document.getElementById("password");
			alert ("Your login - " + l.value + "\n didn't found in DB" );
			alert (p.value);

			};