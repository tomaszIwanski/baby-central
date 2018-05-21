package com.archangel_design.babyscheduller.service;

import com.archangel_design.babyscheduller.entity.LocationEntity;
import com.archangel_design.babyscheduller.entity.UserEntity;
import com.archangel_design.babyscheduller.repository.GenericRepository;
import com.archangel_design.babyscheduller.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LocationService extends GenericRepository {

    @Autowired
    LocationRepository repository;

    public void reportPosition(Long lat, Long lon, Long alt, Date date, UserEntity user) {
        LocationEntity entity = new LocationEntity();
        entity.setLon(lon)
                .setLat(lat)
                .setAlt(alt)
                .setDate(date)
                .setUser(user);

    }

    public List<LocationEntity> fetchRecentLocations(UserEntity user) {
        return repository.fetchRecent(user.getId(), 10);
    }
}
