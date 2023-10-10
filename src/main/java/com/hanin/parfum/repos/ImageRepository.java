package com.hanin.parfum.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanin.parfum.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
