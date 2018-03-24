package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Exception.BadRequestException;
import com.demo.Model.FileUploadResponse;
import com.demo.Service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/api/upload/files", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam("fileName") MultipartFile fileName) throws Exception {

		if (fileName.isEmpty()) {
			throw new BadRequestException("Please choose file that needs to be uploaded");
		}

		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(fileName.getOriginalFilename());
		boolean isFileUploaded = fileService.isFileUploaded(fileName);
		if (isFileUploaded) {
			response.setFileUploadResponse("File has been SUCCESSFULLY uploaded!!");
			return new ResponseEntity<FileUploadResponse>(response, HttpStatus.OK);
		} else {
			response.setFileUploadResponse("File upload has FAILED. Please use valid destination path or try again later");
			return new ResponseEntity<FileUploadResponse>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
