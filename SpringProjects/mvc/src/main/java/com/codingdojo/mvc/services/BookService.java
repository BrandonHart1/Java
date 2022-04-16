package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService 
{
	private final BookRepository bookRepository; // ----- will call all the methods, ex:findAll() -----
	
	public BookService(BookRepository bookRepository)
	{
		this.bookRepository = bookRepository;
	}
	
	// ---------- returns all the books ----------
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    //  ---------- creates a book ----------
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // ---------- retrieves a book ----------
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // ---------- update a book ----------
    public Book updateBook(Book book) 
    {
    	return bookRepository.save(book);
	}
    

    // ---------- delete a book ----------
	public void deleteBook(Long id) 
	{
		bookRepository.deleteById(id);  // deleteById comes with repository after entering "."
	}

	

	
    
    
}
