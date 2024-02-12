package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController{
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("bookList");
		 modelAndView.addObject("book", list);
		 return modelAndView;
	}
	
	@PostMapping("/save") //send data from view to controller
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/available_books";
	}
	
}