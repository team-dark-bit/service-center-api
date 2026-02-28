package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ServiceDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaServiceRepository extends JpaRepository<ServiceDao, String> {
}
