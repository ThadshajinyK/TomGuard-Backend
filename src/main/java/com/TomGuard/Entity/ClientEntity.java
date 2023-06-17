package com.TomGuard.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactPerson;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String businessType;

    @Column(nullable = false)
    private String projectType;

    @Column(nullable = true)
    private String projectName;

    @Column(nullable = false)
    private String projectScope;

    @Column(nullable = false)
    private String targetAudience;

    @Column(nullable = false)
    private String expectedFeatures;


    public ClientEntity() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ClientEntity(Long id, String companyName, String contactPerson, String emailAddress,
                        String phoneNumber, String businessType, String projectType, String projectName,
                        String projectScope, String targetAudience, String expectedFeatures) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.businessType = businessType;
        this.projectType = projectType;
        this.projectName = projectName;
        this.projectScope = projectScope;
        this.targetAudience = targetAudience;
        this.expectedFeatures = expectedFeatures;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectScope() {
        return projectScope;
    }

    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getExpectedFeatures() {
        return expectedFeatures;
    }

    public void setExpectedFeatures(String expectedFeatures) {
        this.expectedFeatures = expectedFeatures;
    }
}
