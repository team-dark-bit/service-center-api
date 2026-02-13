package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.domain.model.Category;
import com.enterprise.servicecenter.application.port.out.CategoryRepository;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.CategoryDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaCategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryRepository {

  private final JpaCategoryRepository jpaCategoryRepository;

  @Override
  public void save(Category category) {
    CategoryDao categoryDao = new CategoryDao(category);
    this.jpaCategoryRepository.save(categoryDao);
  }

  @Override
  public List<Category> findAllByActiveTrue() {
    return jpaCategoryRepository.findAllByActiveTrue()
            .stream()
            .map(CategoryDao::toDomain)
            .toList();
  }
}
