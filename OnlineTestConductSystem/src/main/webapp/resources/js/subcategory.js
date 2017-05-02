$(document).ready(function(){
    $("#add").on("click", function(){
	    var id;
		if($('#c_table tr:last td:first').text() == "" || $('#c_table tr:last td:first').text() == "NaN"){
			id = 1;
		}else{
			id = parseInt($('#c_table tr:last td:first').text()) + 1;
		}
	    $("#c_table tr:last").after("<tr><td>"+id+"</td><td>"+$("#sel1").val()+"</td><td>"+$("#cat").val()+"</td><td><button type='button' id='del"+id+"' class='btn del' onclick='delCategory(this)'><span class='glyphicon glyphicon-remove'></span></button></td></tr>");
    });
});

function delCategory(obj){
    $("#"+obj.id).parent().parent().remove();
}