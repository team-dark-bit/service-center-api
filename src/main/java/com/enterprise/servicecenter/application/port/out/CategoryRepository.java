package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Category;
import java.util.List;

public interface CategoryRepository {
    void save(Category category);
    List<Category> findAllByActiveTrue();
}
