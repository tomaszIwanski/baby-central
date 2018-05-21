/*
 * Baby Central
 * Application for 21'st century parents
 * @author Rafal Martinez-Marjanski
 */

package com.archangel_design.babyscheduller.entity;

import com.archangel_design.babyscheduller.service.LocationService;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

/**
 * LocationEntity.
 */
@Entity
@Table(name = "locations")
public class LocationEntity {

    /**
     * Minimum distance required to assume that
     * location has changed.
     */
    private static final int MIN_DISTANCE_METERS = 30;

    /**
     * Numerical unique identifier.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Latitude.
     */
    private Long lat;

    /**
     * Longitude.
     */
    private Long lon;

    /**
     * Altitude.
     */
    private Long alt;

    /**
     * Location update date.
     */
    private Date date;

    /**
     * Location precision.
     */
    private Long prec;

    /**
     * Sender's device id.
     */
    private String deviceId;

    /**
     * Sender.
     */
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    /**
     *
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param newId id
     * @return this
     */
    public LocationEntity setId(final Long newId) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return latitude
     */
    public Long getLat() {
        return lat;
    }

    /**
     *
     * @param newLat latitude
     * @return this
     */
    public LocationEntity setLat(final Long newLat) {
        this.lat = newLat;
        return this;
    }

    /**
     *
     * @return longitude
     */
    public Long getLon() {
        return lon;
    }

    /**
     *
     * @param newLon longitude
     * @return this
     */
    public LocationEntity setLon(final Long newLon) {
        this.lon = newLon;
        return this;
    }

    /**
     *
     * @return altitude
     */
    public Long getAlt() {
        return alt;
    }

    /**
     *
     * @param newAlt altitude
     * @return this
     */
    public LocationEntity setAlt(final Long newAlt) {
        this.alt = newAlt;
        return this;
    }

    /**
     *
     * @return update date
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param newDate update date
     * @return this
     */
    public LocationEntity setDate(final Date newDate) {
        this.date = newDate;
        return this;
    }

    /**
     *
     * @return this
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     *
     * @param newUser sender
     * @return this
     */
    public LocationEntity setUser(final UserEntity newUser) {
        this.user = newUser;
        return this;
    }

    /**
     *
     * @return device ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     *
     * @param newDeviceId string device ID
     * @return this
     */
    public LocationEntity setDeviceId(final String newDeviceId) {
        this.deviceId = newDeviceId;
        return this;
    }

    /**
     *
     * @return precision
     */
    public Long getPrec() {
        return prec;
    }

    /**
     *
     * @param newPrecision precision
     * @return this
     */
    public LocationEntity setPrec(final Long newPrecision) {
        prec = newPrecision;
        return this;
    }

    /**
     *
     * @param obj object to compare
     * @return true id objects are the same
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof LocationEntity)) {
            return false;
        }

        if (getLat().compareTo(((LocationEntity) obj).getLat()) != 0) {
            return false;
        }

        if (getLon().compareTo(((LocationEntity) obj).getLon()) != 0) {
            return false;
        }

        if (getAlt().compareTo(((LocationEntity) obj).getAlt()) != 0) {
            return false;
        }

        if (getDeviceId() != null) {
            if (!getDeviceId().equals(((LocationEntity) obj).getDeviceId())) {
                return false;
            }
        }

        return getDate().equals(((LocationEntity) obj).getDate());
    }

    /**
     *
     * @param otherLocation location to compare with
     * @return true if closer than 30 meters
     */
    public Boolean close(final LocationEntity otherLocation) {
        Double dist = LocationService.distance(
                getLat(), otherLocation.getLat(),
                getLon(), otherLocation.getLon(),
                getAlt(), otherLocation.getAlt()
        );

        return dist <= MIN_DISTANCE_METERS;
    }

    /**
     *
     * @return integer hash code
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
