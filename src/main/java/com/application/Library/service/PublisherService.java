package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Publisher;
import com.application.Library.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	public List<Publisher> findAllPublisher() {
		return publisherRepository.findAll();
	}

	public Publisher findPublisherById(Long id) {
		return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not Found"));
	}

	public void createPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	public void deletePublisher(Long id) {
		Publisher publisher = publisherRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Publisher not Found"));
		publisherRepository.deleteById(publisher.getId());
	}
}
