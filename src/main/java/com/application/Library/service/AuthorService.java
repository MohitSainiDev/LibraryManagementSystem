package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Author;
import com.application.Library.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Author findAuthorById(Long id) {
		return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not Found"));
	}

	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	public void deleteAuthorById(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not Found"));
		authorRepository.deleteById(author.getId());
	}
}
