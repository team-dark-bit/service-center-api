
package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection;

import com.enterprise.servicecenter.application.dto.response.product.catalog.PackageCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForCatalogProjection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ProductCatalogProjectionResponseMapper {

  protected abstract PackageCatalogResponse toPackage(ProductForCatalogProjection projection);

  @Mapping(target = "packages", ignore = true)
  protected abstract ProductCatalogResponse toProduct(ProductForCatalogProjection projection);

  public List<ProductCatalogResponse> toResponses(List<ProductForCatalogProjection> projections) {
    if (projections == null || projections.isEmpty()) {
      return Collections.emptyList();
    }

    Map<String, List<ProductForCatalogProjection>> grouped = projections.stream()
            .collect(Collectors.groupingBy(ProductForCatalogProjection::getProductId, LinkedHashMap::new, Collectors.toList()));

    return grouped.values().stream()
            .map(list -> {
              ProductForCatalogProjection first = list.getFirst();
              ProductCatalogResponse product = toProduct(first);
              List<PackageCatalogResponse> packages = list.stream()
                      .map(this::toPackage)
                      .filter(Objects::nonNull)
                      .collect(Collectors.toList());
              product.setPackages(packages);
              return product;
            })
            .collect(Collectors.toList());
  }
}