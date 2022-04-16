package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController 
{
	@Autowired  // <<<---------- automatically does dependency injection ----------
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId)
	{
		System.out.println(bookId); // ----- verify book in the console -----
		
		Book book = bookService.findBook(bookId);
		System.out.println(book); // ----- verify book id and object in the console -----
		
		model.addAttribute("book", book);
		
//		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
//		
//		model.addAttribute("books",books);
		
	
		return "index.jsp";
		
	}
	
}
