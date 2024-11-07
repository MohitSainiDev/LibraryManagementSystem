package com.application.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.Library.entity.Category;
import com.application.Library.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryService.findAllCategories());
		return "categories";
	}

	@GetMapping("/remove-category/{id}")
	public String DeleteCategory(@PathVariable Long id, Model model) {
		categoryService.deleteCategoryById(id);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "categories";
	}

	@GetMapping("/update-category/{id}")
	public String updateCategory(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryService.findCategoryById(id));
		return "update-category";
	}

	@PostMapping("/update-category/{id}")
	public String saveCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-category";
		}
		categoryService.updateAuthor(category);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "redirect:/categories";
	}

	@GetMapping("/add-category")
	public String showCreateCategory(Category category) {
		return "add-category";
	}

	@PostMapping("/save-category")
	public String saveCategory(Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-category";
		}
		categoryService.createCategory(category);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "redirect:/categories";
	}
}
