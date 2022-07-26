package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.Entity.Book;
import com.test.helper.fileUploadHelper;

@RestController
public class UploadController {

	@Autowired
	private fileUploadHelper fileuploadHelp;
	
	@GetMapping("/getBook")
	public ResponseEntity<Book> getBook(){
		
		Book b = new Book(1, "testBook");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(b);
	}
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		System.out.println(file.getOriginalFilename());
		try {
		    boolean f = fileuploadHelp.fileUpload(file);
			if(f) {
				return ResponseEntity.ok("working");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in file upload");
	}
}
