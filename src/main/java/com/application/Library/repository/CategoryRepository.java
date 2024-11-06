package com.application.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
