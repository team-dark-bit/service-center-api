package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.domain.model.Brand;
import com.enterprise.servicecenter.application.port.out.BrandRepository;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.BrandDao;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaBrandRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.BRAND_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class BrandPersistenceAdapter implements BrandRepository {

  private final JpaBrandRepository jpaBrandRepository;

  @Override
  public void save(Brand brand) {
    BrandDao brandDao = new BrandDao(brand);
    jpaBrandRepository.save(brandDao);
  }

  @Override
  public Brand findById(String id) {
    return jpaBrandRepository.findById(id)
            .map(BrandDao::toDomain)
            .orElseThrow(() -> new ApplicationException(BRAND_NOT_FOUND, id));
  }

  @Override
  public List<Brand> findAllByActiveTrue() {
    return jpaBrandRepository.findAllByActiveTrue()
            .stream()
            .map(BrandDao::toDomain)
            .toList();
  }
}
