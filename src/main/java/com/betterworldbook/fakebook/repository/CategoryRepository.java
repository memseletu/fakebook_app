package com.betterworldbook.fakebook.repository;

import com.betterworldbook.fakebook.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
