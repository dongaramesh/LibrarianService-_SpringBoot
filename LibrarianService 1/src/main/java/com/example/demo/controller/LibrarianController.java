package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modal.Book;

@RestController
@RequestMapping("/librarianService")
public class LibrarianController {

	@Autowired
	private RestTemplate restTemplate;
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBookById(@PathVariable int id) {
		restTemplate.delete("http://bookservice/bookService/deleteBookById/{id}", id);
		return "deleted book successfully";
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable int id) {
		restTemplate.delete("http://studentservice/studentService/deleteStudentById/{id}", id);
		return "Student deleted duccessfully";
	}
	
	@PostMapping("/addBook1")
	public String registerBook(@RequestBody Book book) {
		String result=restTemplate.postForObject("http://bookservice/bookService/addBook", book, String.class);
		
		return result;
	}
	
}
