  function payWithPaystack(){
	
	var fullname = $('#fullname').val();
	var phone = $('#phone').val();
	var email = $('#email').val();
	var address = $('#address').val();
    var amount  =  $('#amount').val();

	if((fullname=="")&&(phone=="")&&(email=="")&&(address=="")) {
		
		alert('Please fill all values on the ordering form');
	}
	else{
	    var handler     = PaystackPop.setup({
	      key: 'pk_test_9fffdfb13c6194a5a236b933ddb00aa29a78dd78',
	      email: email,
	      amount: amount +'00',
	      //channels: ['card'],
	      channels: ['card','bank', 'ussd', 'qr', 'mobile_money', 'bank_transfer'],
	      ref: ''+Math.floor((Math.random() * 1000000000) + 1), // generates a pseudo-unique reference. Please replace with a reference you generated. Or remove the line entirely so our API will generate one for you
	      metadata: {
	         custom_fields: [
	            {
	                display_name: "Mobile Number",
	                variable_name: "mobile_number",
	                value: "+2349037072904"
	            }
	         ]
	      },
	      callback: function(response){
	       
	        //var amount = $("input[name=amount]").val();
	
			
	
	        alert('success. transaction ref is ' + response.reference);
	        location.reload();
	         
	      },
	      onClose: function(){
	          //alert('window closed');
	      }
	    });
	    handler.openIframe();
	}
  }

