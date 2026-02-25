package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PurchaseNumberGenerator {
  private final JdbcTemplate jdbc;

  public PurchaseNumberGenerator(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Integer next() {
    Long next = jdbc.queryForObject("SELECT nextval('purchase_number_seq')", Long.class);
    return next == null ? 1 : next.intValue();
  }
}