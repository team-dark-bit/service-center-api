package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.Brand;
import com.enterprise.servicecenter.application.port.out.BrandRepository;
import com.enterprise.servicecenter.domain.model.BrandDao;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaBrandRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepositoryPersistence implements BrandRepository {

  private final JpaBrandRepository jpaBrandRepository;

  public BrandRepositoryPersistence(JpaBrandRepository jpaBrandRepository) {
    this.jpaBrandRepository = jpaBrandRepository;
  }

  @Override
  public void save(Brand brand) {
    BrandDao brandDao = new BrandDao(brand);
    jpaBrandRepository.save(brandDao);
  }
}
