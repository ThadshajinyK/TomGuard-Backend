package com.TomGuard.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="server")
public class ServerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Timestamp timestamp;
    @Column(nullable = true)
    private String hostName;

    @Column(nullable = true)
    private String ipAddress;

    @Column(nullable = true)
    private Long uptime;

    @Column(nullable = true)
    private String availability;

    @Column(nullable = true)
    private String osName;

    @Column(nullable = true)
    private String osVersion;

    @Column(nullable = true)
    private String osArchitecture;

    @Column(nullable = true)
    private String jvmVersion;

    public ServerEntity() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ServerEntity(Long id,String hostName, String ipAddress, Long uptime, String availability, String osName, String osVersion, String osArchitecture, String jvmVersion) {
        this.id = id;
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.uptime = uptime;
        this.availability = availability;
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.jvmVersion = jvmVersion;
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getUptime() {
        return uptime;
    }

    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArchitecture() {
        return osArchitecture;
    }

    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }

}