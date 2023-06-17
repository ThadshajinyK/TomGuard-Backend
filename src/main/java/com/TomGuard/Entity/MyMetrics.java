package com.TomGuard.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="metrics")
public class MyMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(nullable = true)
    private String availability;

    @Column(nullable = true)
    private Long uptimeInMillis;

    @Column(nullable = true)
    private Long responseTimeInMillis;

    @Column(nullable = true)
    private Long requestTimeInMillis;

    public MyMetrics() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public MyMetrics(Long id, String availability, Long uptimeInMillis, Long responseTimeInMillis, Long requestTimeInMillis) {
        this.id = id;
        this.availability = availability;
        this.uptimeInMillis = uptimeInMillis;
        this.responseTimeInMillis = responseTimeInMillis;
        this.requestTimeInMillis = requestTimeInMillis;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Long getUptimeInMillis() {
        return uptimeInMillis;
    }

    public void setUptimeInMillis(Long uptimeInMillis) {
        this.uptimeInMillis = uptimeInMillis;
    }

    public Long getResponseTimeInMillis() {
        return responseTimeInMillis;
    }

    public void setResponseTimeInMillis(Long responseTimeInMillis) {
        this.responseTimeInMillis = responseTimeInMillis;
    }

    public Long getRequestTimeInMillis() {
        return requestTimeInMillis;
    }

    public void setRequestTimeInMillis(Long requestTimeInMillis) {
        this.requestTimeInMillis = requestTimeInMillis;
    }
}
