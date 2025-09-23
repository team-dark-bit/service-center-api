package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.Subcategory;
import com.enterprise.servicecenter.application.port.out.SubcategoryRepository;
import com.enterprise.servicecenter.domain.model.SubcategoryDao;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaSubcategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_NOT_FOUND;
import static java.util.stream.Collectors.toList;

@Repository
@AllArgsConstructor
public class SubcategoryPersistence implements SubcategoryRepository {

  private final JpaSubcategoryRepository jpaSubcategoryRepository;



  @Override
  public void save(Subcategory subcategory) {
    SubcategoryDao subcategoryDao = new SubcategoryDao(subcategory);
    jpaSubcategoryRepository.save(subcategoryDao);

  }

  @Override
  public Subcategory findById(String id) {
    return jpaSubcategoryRepository.findById(id)
            .map(SubcategoryDao::toDomain).orElseThrow(()-> new ApplicationException(PRODUCT_NOT_FOUND, id));
  }

  @Override
  public List<Subcategory> findByCategoryId(String categoryId) {
    return jpaSubcategoryRepository.findByCategoryId(categoryId)
            .stream()
            .map(SubcategoryDao::toDomain)
            .toList();

  }
}
