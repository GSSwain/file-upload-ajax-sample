package com.gsswain.file;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	// endpoint for https://stackoverflow.com/questions/49845355/spring-boot-controller-upload-multipart-and-json-to-dto/49993072#49993072
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void upload(@RequestPart("user") @Valid User user,
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
		System.out.println(user);
		printFileDetails(file);
	}

	// endpoint for https://stackoverflow.com/questions/67023339/error-making-http-post-with-file-in-request-body/67085556#67085556
	@RequestMapping(value = "/api/endpoint", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void upload(@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
		printFileDetails(file);
	}

	private void printFileDetails(MultipartFile file) {
		System.out.println("Uploaded File: ");
		System.out.println("Name : " + file.getName());
		System.out.println("Type : " + file.getContentType());
		System.out.println("Name : " + file.getOriginalFilename());
		System.out.println("Size : " + file.getSize());
	}
}
