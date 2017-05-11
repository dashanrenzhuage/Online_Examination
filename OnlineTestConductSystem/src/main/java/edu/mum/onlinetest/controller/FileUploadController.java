package edu.mum.onlinetest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.onlinetest.model.FileLocation;
import edu.mum.onlinetest.service.FileUploadServiceInterface;

@Controller
public class FileUploadController {

	@Autowired
	FileUploadServiceInterface fileUploadService;

	@RequestMapping(value = "question/uploadFile", method = RequestMethod.GET)
	public String uploadFile() {
		return "questionUpload";
	}

	@RequestMapping(value = "question/uploadFile", method = RequestMethod.POST)
	public void upload(@RequestParam("file") MultipartFile file) {
		String name = "test.xlsx";
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();

				FileLocation fileLocation = new FileLocation();

				fileLocation.setFileimage(bytes);

				fileUploadService.saveFileLocation(fileLocation);
				String str = fileUploadService.getFileLocationByID((long) 49).getFileimage().toString();

				byte[] bdata = str.getBytes();
				System.out.println(bdata);
				System.out.println(fileUploadService.getFileLocationByID((long) 49).getFileimage());
				System.out.println("***********" + stream);
				System.out.println("You successfully uploaded " + name + "!");
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + name + " because the file was empty.");
		}
	}

}