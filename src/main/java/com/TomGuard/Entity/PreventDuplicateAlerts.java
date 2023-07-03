package com.TomGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PDA")
public class PreventDuplicateAlerts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long checkedMetricId;
}
