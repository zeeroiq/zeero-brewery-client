package com.shri.zeero.repository;

import com.shri.zeero.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by zeeroiq on 9/8/20, 5:14 AM
 */

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
