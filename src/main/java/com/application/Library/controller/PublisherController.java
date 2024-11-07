package com.application.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.Library.entity.Publisher;
import com.application.Library.service.PublisherService;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping("/publishers")
	public String findAllPublishers(Model model) {
		model.addAttribute("publishers", publisherService.findAllPublisher());
		return "publishers";
	}

	@GetMapping("/remove-publisher/{id}")
	public String DeletePublisher(@PathVariable Long id, Model model) {
		publisherService.deletePublisher(id);
		model.addAttribute("publishers", publisherService.findAllPublisher());
		return "publishers";
	}

	@GetMapping("/update-publisher/{id}")
	public String updatePublisher(@PathVariable Long id, Model model) {
		model.addAttribute("publisher", publisherService.findPublisherById(id));
		return "update-publisher";
	}

	@PostMapping("/update-publisher/{id}")
	public String saveCategory(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-category";
		}
		publisherService.updatePublisher(publisher);
		model.addAttribute("publishers", publisherService.findAllPublisher());
		return "redirect:/publishers";
	}

	@GetMapping("/add-publisher")
	public String showCreatePage(Publisher publisher) {
		return "add-publisher";
	}

	@PostMapping("/save-publisher")
	public String CreatePublisher(Publisher publisher, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-category";
		}
		publisherService.createPublisher(publisher);
		model.addAttribute("publishers", publisherService.findAllPublisher());
		return "redirect:/publishers";
	}
}
