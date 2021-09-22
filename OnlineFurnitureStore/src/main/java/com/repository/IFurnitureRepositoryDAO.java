package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Furniture;
@Repository
public interface IFurnitureRepositoryDAO extends JpaRepository<Furniture, Long> {

	@Query(" from Furniture f where f.furnitureName = :furnitureName")
	Furniture findbyName(String furnitureName);
}
