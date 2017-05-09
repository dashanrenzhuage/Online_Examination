

var contextRoot = "/" + window.location.pathname.split('/')[1];
$(function() {
	$("#subcategory").hide();
	$("#sel_subcategory").hide();

	$("#category")
			.change(
					function() {
						var id = $("#category").val();
						$
								.ajax({

									type : 'GET',
									url : contextRoot
											+ "/subCategories/getSubCategoryFromCategory/"
											+ id,
									data : {},
									datatype : "json",
									contentType : 'application/json',
									success : function(response) {
										//alert(response);
										displaySubCategory(response);
									},
									error : function() {
										alert('Error while request...');
									}

								});
					});

	function displaySubCategory(categorylist) {
		$("#subcategory").show();
		$("#sel_subcategory").show();
		
		$('#subCategory').empty();
       
        $.each(categorylist, function (k, v) {
            $('#subCategory').append('<option value="' + v.id + '">' + v.subCatName + '</option>')
        })
	}
})

/*
 * $(document).on('change','#categorylll',function(){ alert('Change Happened');
 * var sendData = {'sel1':
 * $("#sel1").find("option:selected").val()};//alert($("#sel1").find("option:selected").val());
 * $.ajax({ url:url, type:'get', data:sendData,
 * success:function(data){alert("asd"); //if(data == 1){
 * //$("#sel_subcategory").html("asdsad"); //} } }); });
 */

/*
 * $(function(){ $("#categorylll").change(function(){
 * 
 * }); })
 */
/*
 * $("#categorylll").change(function(){ alert("kcha"); var url =
 * 'stu_sel_exam.txt'; var sendData = {'sel1':
 * $("#sel1").find("option:selected").val()};//alert($("#sel1").find("option:selected").val());
 * $.ajax({ url:url, type:'get', data:sendData,
 * success:function(data){alert("asd"); //if(data == 1){
 * //$("#sel_subcategory").html("asdsad"); //} } }); })
 */

// alert($("#sel_category").length);
/*
 * $("#category").click(function(){ alert("hello"); });
 * 
 * $("#category").change(function(){ alert("kcha"); var url =
 * 'stu_sel_exam.txt'; var sendData = {'sel1':
 * $("#sel1").find("option:selected").val()};//alert($("#sel1").find("option:selected").val());
 * $.ajax({ url:url, type:'get', data:sendData,
 * success:function(data){alert("asd"); //if(data == 1){
 * //$("#sel_subcategory").html("asdsad"); //} } }); })
 */