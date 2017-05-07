$(document).ready(function(){
    $(".add").on("click", function(){
	    if($('form').children().length == 9){
	        $("#Odiv3").after("<div id='Odiv4' class='form-group'><div class='row'><div class='col-sm-1'></div><div class='col-sm-9'><input type='text' class='form-control' id='option4' name='option4' placeholder='Enter option 4 here' /></div><div class='col-sm-2'><button type='button' id='add4' class='btn add' onclick='addOption()'><span class='glyphicon glyphicon-plus'></span></button><button type='button' id='del4' class='btn del' onclick='delOption()'><span class='glyphicon glyphicon-remove'></span></button></div></div></div>");
	        $('#add3').hide();
	    }
    });
});
  
function addOption(){
    if($('form').children().length == 10){
	    $("#Odiv4").after("<div id='Odiv5' class='form-group'><div class='row'><div class='col-sm-1'></div><div class='col-sm-9'><input type='text' class='form-control' id='option5' name='option5' placeholder='Enter option 5 here' /></div><div class='col-sm-2'><button type='button' id='add5' class='btn add' onclick='addOption()'><span class='glyphicon glyphicon-plus'></span></button><button type='button' id='del5' class='btn del' onclick='delOption()'><span class='glyphicon glyphicon-remove'></span></button></div></div></div>");
	    $('#add3').hide();
	    $('#add4').hide();
	    $('#del4').hide();
	    $('#add5').hide();
    }
}

function delOption(){
    if($('form').children().length == 10){
	    $("#Odiv4").remove();
	    $('#add3').show();
    }else if($('form').children().length == 11){
	    $("#Odiv5").remove();
	    $('#add4').show();
	    $('#del4').show();
    }
}