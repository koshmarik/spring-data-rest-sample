package org.koshenkova.sample.rest;

import org.koshenkova.sample.domain.MapPoint;
import org.koshenkova.sample.dto.MapPointDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


//@RepositoryRestResource//(excerptProjection = MapPointDto.class)
@RestResource(path = "map_point", rel = "map_point")
public interface MapPointRepository extends PagingAndSortingRepository<MapPoint, Long> {

    Page<MapPoint> findAll(Pageable pageable);

}
