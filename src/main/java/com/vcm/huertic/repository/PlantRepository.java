package com.vcm.huertic.repository;

import com.vcm.huertic.entity.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, String> {
}
