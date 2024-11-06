package com.application.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Library.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
