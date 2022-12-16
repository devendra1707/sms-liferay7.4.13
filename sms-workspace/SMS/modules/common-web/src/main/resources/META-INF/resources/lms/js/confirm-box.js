var functionName;
jQuery(document).ready(
		

		function($) {
			// open popup

			loadDelay(function() {
			
			// close popup
			$('.cd-popup').on(
					'click',
					function(event) {
						if ($(event.target).is('.cd-popup-close')
								|| $(event.target).is('.cd-popup')) {
							event.preventDefault();
							$(this).removeClass('is-visible');
						}
					});
			$('#noButton').on('click', function(event) {
				// alert("hello");
				event.preventDefault();
				$('.cd-popup').removeClass('is-visible');

			});
			// close popup when clicking the esc keyboard button
			$(document).keyup(function(event) {
				if (event.which == '27') {
					$('.cd-popup').removeClass('is-visible');
				}
			});
			},500);
		});

function callOpenBox(textInfo,callBack) {
	//alert("helloooooooooooooooo");
	//alert(textInfo+","+callBack);
	$("#confirmBox").show();
	// event.preventDefault();
	$('#confirmMsg').text(textInfo);
//	$('.cd-popup').addClass('is-visible');
	$('#confirmBox').addClass('is-visible');
	$('#okButton').unbind().on('click', function(event) {
		event.preventDefault();
		  if(callBack != undefined){
		callBack();
		  }
		$('.cd-popup').removeClass('is-visible');

	});
	
}
function callOpenBoxHTML(textInfo,callBack) {
	//alert("hiiiiiiiiiiiii");
	// event.preventDefault();
	$('#confirmMsg').html(textInfo);
//	$('.cd-popup').addClass('is-visible');
	$('#confirmBox').addClass('is-visible');
	$('#okButton').unbind().on('click', function(event) {
		event.preventDefault();
		
		  if(callBack != undefined){
		callBack();
		  }
		$('.cd-popup').removeClass('is-visible');

	});
	
}

function openOkBox(textInfo,callBack) {
	$("#okBox").show();
	$('#okMsg').text(textInfo);
$('#okBox').addClass('is-visible');
	//$('#okBox').text("OK");
	
	$('#confirmButton').unbind().on('click', function(event) {
		$('#okBox').removeClass('is-visible');
		if(callBack != undefined){
			callBack();
			  }
		return true;
	});
	return true;
}


function openOkBox(textInfo,callBack) {
	$("#okBox").show();
	$('#okMsg').text(textInfo);
$('#okBox').addClass('is-visible');
	//$('#okBox').text("OK");
	
	$('#confirmButton').unbind().on('click', function(event) {
		$('#okBox').removeClass('is-visible');
		if(callBack != undefined){
			callBack();
			  }
		return true;
	});
	return true;
}
function showErrorMessage(containerId,msg){
	$('#'+containerId).text(msg);
	 try{
		 $('#'+containerId).focus();
	  }catch(e){}
	  $('#'+containerId).addClass('bounceIn animated');
	  setTimeout(function(){
		  $('#'+containerId).removeClass('bounceIn animated');
	  }, 1000);
	//alert("Options must be greater than or equal to three.");
	hideProgress();
}