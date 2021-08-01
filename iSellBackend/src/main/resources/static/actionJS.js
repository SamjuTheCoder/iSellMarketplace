$(document).ready(function () {
          $('select').selectize({
              sortField: 'text'
          });

});


  function payWithPaystack(){
    var fundamount  =  $('#amount').val();
    var email       =  $('#email').val();
    var handler     = PaystackPop.setup({
      key: 'pk_test_9fffdfb13c6194a5a236b933ddb00aa29a78dd78',
      email: email,
      amount: fundamount+'00',
      //channels: ['card'],
      channels: ['bank', 'ussd', 'qr', 'mobile_money', 'bank_transfer'],
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
       
        var amount = $("input[name=amount]").val();

		$.ajax({
		 url: murl +'/add-fund',
		 type: "post",
		 data: {'amount':amount, '_token': $('input[name=_token]').val()},
		 success: function(data){
		 
		 console.log(data);
		 
		 }
		 
		});

        alert('success. transaction ref is ' + response.reference);
        location.reload();
         
      },
      onClose: function(){
          //alert('window closed');
      }
    });
    handler.openIframe();
  }


 function funcDelete(x)
{
	var y = confirm('Are you sure you want to delete?')
	if(y==true)
	{
		document.location="/delete-customer/"+x;
	}
		
}
 function funcDeleteStaff(x)
{
	var y = confirm('Are you sure you want to delete this staff?')
	if(y==true)
	{
		document.location="/delete-staff/"+x;
	}
		
}

 function funcEnableStaff(x)
{
	var y = confirm('Are you sure you want to enable this staff?')
	if(y==true)
	{
		document.location="/enable-staff/"+x;
	}
		
}

 function funcDisableStaff(x)
{
	var y = confirm('Are you sure you want to disable this staff?')
	if(y==true)
	{
		document.location="/disable-staff/"+x;
	}
}


function funcActivateRate(x)
{
	var y = confirm('Are you sure you want to make this the current rate?')
	if(y==true)
	{
		document.location="/enable-rate/"+x;
	}
		
}

 function funcDeActivateRate(x)
{
	var y = confirm('Are you sure you want to disable this rate?')
	if(y==true)
	{
		document.location="/disable-rate/"+x;
	}
}

 function funcApprove(x)
{
	var y = confirm('Are you sure you want to Approve this Account?')
	if(y==true)
	{
		document.location="/approve-customer/"+x;
	}
		
}

function funcEdit(x)
{
	var y = confirm('Are you sure you want to Edit?')
	if(y==true)
	{
		document.location="/edit-customer/"+x;
	}
		
}
function funcEditStaff(x)
{
	var y = confirm('Are you sure you want to Edit?')
	if(y==true)
	{
		document.location="/edit-staffs/"+x;
	}
		
}
function searchByAccountOfficer()
{
	var y = document.getElementById('accountOfficer').value;
	
	//alert(y);
	document.location = "/search-by-account-officer/"+y;
}

function searchByBranch()
{
	var y = document.getElementById('branchid').value;
	
	//alert(y);
	document.location = "/search-by-branch/"+y;
}
function searchByAccountStatus()
{
	var y = document.getElementById('accountStatus').value;
	
	//alert(y);
	document.location = "/search-by-account-status/"+y;
}

//branch
function editBranch(x)
{
	var y = confirm("Are you sure?");
	
	if(y==true)
	{
		document.location = "/edit-branch/" + x;
	}
}

function deleteBranch(x)
{
	var y = confirm("Are you sure you want to delete?");
	
	if(y==true)
	{
		document.location = "/delete-branch/" + x;
	}
}

function searchByBranchId()
{
	var y = document.getElementById('branchid').value;
	
	//alert(y);
	document.location = "/search-staff-branch/"+y;
}

function viewMandate()
{
	var y = document.getElementById('customerid').value;
	
	document.location = "/view-mandate/"+y;
}
//rate
function deleteRate(x)
{
	var y = confirm('Are you sure you want to delete?')
	if(y==true)
	{
		document.location="/delete-rate/"+x;
	}
		
}

function editRate(x)
{
	var y = confirm('Are you sure yous?')
	if(y==true)
	{
		document.location="/edit-rate/"+x;
	}
		
}



  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });

 $(function () {
    // Summernote
    $('#summernote').summernote()

    // CodeMirror
    CodeMirror.fromTextArea(document.getElementById("codeMirrorDemo"), {
      mode: "htmlmixed",
      theme: "monokai"
    });
  })
