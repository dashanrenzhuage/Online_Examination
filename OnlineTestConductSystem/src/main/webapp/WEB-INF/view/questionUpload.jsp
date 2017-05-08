<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<form method="POST" action="uploadFile" enctype="multipart/form-data">
	FILE to upload: <input type="file" class="file" name="file"/>
 
		Name: <input type="text" name="name">
 
 
		<input type="submit" value="Upload"> Press here to upload THE FILE!
	</form>	
</body>
</html>