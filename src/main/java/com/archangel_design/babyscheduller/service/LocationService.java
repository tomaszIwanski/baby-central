package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LocationService extends GenericRepository {

    public void reportPosition(Long lat, Long lon, Long alt, Date date, UserEntity user) {

    }
}
