package com.ccsw.tutorialcategory.category;

import com.ccsw.tutorialcategory.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// @author ccsw

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
