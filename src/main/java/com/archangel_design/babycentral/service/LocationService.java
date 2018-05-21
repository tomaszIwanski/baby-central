package com.archangel_design.babycentral.service;

import com.archangel_design.babycentral.entity.LocationEntity;
import com.archangel_design.babycentral.entity.UserEntity;
import com.archangel_design.babycentral.repository.GenericRepository;
import com.archangel_design.babycentral.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * LocationService.
 */
@Service
public class LocationService extends GenericRepository {

    /**
     * Location repository.
     */
    @Autowired
    private LocationRepository repository;

    /**
     * Number of last location updates returned.
     */
    private static final int MAX_LAST_LOCATIONS = 10;

    /**
     * Number of meters in kilometers.
     */
    private static final int METERS_IN_KM = 1000;

    /**
     *
     * @param lat latitude
     * @param lon longitude
     * @param alt altitude
     * @param precision precision
     * @param date current date
     * @param user current user
     */
    public void reportPosition(
            final Long lat,
            final Long lon,
            final Long alt,
            final Long precision,
            final Date date,
            final UserEntity user,
            final String deviceId
    ) {
        LocationEntity entity = new LocationEntity();
        entity.setLon(lon)
                .setLat(lat)
                .setAlt(alt)
                .setDate(date)
                .setPrec(precision)
                .setDeviceId(deviceId)
                .setUser(user);

        List<LocationEntity> lastLocations = fetchRecentLocations(user);

        LocationEntity previousLocation =
                lastLocations.stream().findFirst().orElse(null);

        if (previousLocation != null) {
            if (previousLocation.equals(entity)
                    || previousLocation.close(entity)) {
                return;
            }
        }

        repository.save(entity);
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     *
     * @param lat1 Start point
     * @param lon1 Start point
     * @param lat2 End point
     * @param lon2 End point
     * @param el1 Start altitude in meters
     * @param el2 End altitude in meters
     * @return Distance in Meters
     */
    public static double distance(final double lat1, final double lat2,
                           final double lon1, final double lon2,
                           final double el1, final double el2) {

        final int earthRadius = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c * METERS_IN_KM;

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    /**
     *
     * @param user desired user
     * @return list of last 10 location updates
     */
    public final List<LocationEntity> fetchRecentLocations(
            final UserEntity user) {
        return repository.fetchRecent(user.getId(), MAX_LAST_LOCATIONS);
    }
}
