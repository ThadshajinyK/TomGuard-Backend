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


    public ApplicationEntity() {
    }

    public ApplicationEntity(String applicationName, String state, String path) {
        this.applicationName = applicationName;
        this.state = state;
        this.path = path;
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
