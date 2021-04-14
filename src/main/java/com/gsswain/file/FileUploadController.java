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

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void upload(@RequestPart("user") @Valid User user,
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
			System.out.println(user);
			System.out.println("Uploaded File: ");
			System.out.println("Name : " + file.getName());
			System.out.println("Type : " + file.getContentType());
			System.out.println("Name : " + file.getOriginalFilename());
			System.out.println("Size : " + file.getSize());
	}

	static class User {
		@NotNull
		String firstName;
		@NotNull
		String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
		}

	}
}
