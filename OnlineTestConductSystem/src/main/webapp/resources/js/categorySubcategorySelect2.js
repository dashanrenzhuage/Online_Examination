

var contextRoot = "/" + window.location.pathname.split('/')[1];
$(function() {

	$("#category")
			.change(
					function() {
						var id = $("#category").val();
						
						
						$.ajax({

									type : 'GET',
									url : contextRoot
											+ "/question/get/subcategories/"
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
		$('#subCategory').empty();
		
		$('#subCategory').append('<option value="" >--Select Subcategory--</option>');
        $.each(categorylist, function (k, v) {
            $('#subCategory').append('<option value="' + v.id + '">' + v.subCatName + '</option>');
        })
	}
})