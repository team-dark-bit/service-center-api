package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.SubcategoryRepository;
import com.enterprise.servicecenter.domain.model.Subcategory;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.SubcategoryDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaSubcategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class SubcategoryPersistence implements SubcategoryRepository {

  private final JpaSubcategoryRepository jpaSubcategoryRepository;
  private final SubcategoryDaoDomainMapper subcategoryDaoDomainMapper;

  @Override
  public void save(Subcategory subcategory) {
    jpaSubcategoryRepository.save(subcategoryDaoDomainMapper.toDao(subcategory));

  }

  @Override
  public Subcategory findById(String id) {
    return jpaSubcategoryRepository.findById(id)
            .map(subcategoryDaoDomainMapper::toDomain)
            .orElseThrow(()-> new ApplicationException(PRODUCT_NOT_FOUND, id));
  }

  @Override
  public List<Subcategory> findByCategoryId(String categoryId) {
    return jpaSubcategoryRepository.findByCategoryId(categoryId)
            .stream()
            .map(subcategoryDaoDomainMapper::toDomain)
            .toList();

  }
}
