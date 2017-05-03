alert("hello");
$(document).ready(function() {
	$('#list_stu').DataTable();
} );

$('#list_stu').removeClass( 'display' ).addClass('table table-striped table-bordered');

function delCategory(obj){
    $("#"+obj.id).parent().parent().remove();
}