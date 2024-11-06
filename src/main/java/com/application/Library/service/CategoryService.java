package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Category;
import com.application.Library.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAllAuthors() {
		return categoryRepository.findAll();
	}

	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not Found"));
	}

	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	public void updateAuthor(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not Found"));
		categoryRepository.deleteById(category.getId());
	}
}
