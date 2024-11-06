package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Book;
import com.application.Library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	public BookRepository bookRepository;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book findBookById(Long id) {

		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
	}

	public void createBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Long id)
	{
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
		bookRepository.deleteById(book.getId());
	}
}
