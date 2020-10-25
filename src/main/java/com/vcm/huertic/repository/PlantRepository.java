package com.vcm.huertic.repository;

import com.vcm.huertic.entity.Plant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlantRepository extends PagingAndSortingRepository<Plant, String> {
}
