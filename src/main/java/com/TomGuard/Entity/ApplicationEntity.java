package com.TomGuard.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Apps")
public class ApplicationEntity {

    @Id
    private String applicationName;
    @Column(nullable = true)
    private String state;//running or stopped
    @Column(nullable = true)
    private String path;

    @Column(nullable = true)
    private String appType;

    @Column(nullable = true)
    private String clientName;

    public ApplicationEntity() {
    }

    public ApplicationEntity(String applicationName, String state, String path,String appType, String clientName) {
        this.applicationName = applicationName;
        this.state = state;
        this.path = path;
        this.appType=appType;
        this.clientName= clientName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
