package com.TomGuard.Service;

import com.TomGuard.Repository.PreventDuplicateAlertsRepository;

public class PreventDuplicateAlertsImpl implements PreventDuplicateAlerts{
    private final PreventDuplicateAlertsRepository preventDuplicateAlertsRepository;

    public PreventDuplicateAlertsImpl(PreventDuplicateAlertsRepository preventDuplicateAlertsRepository) {
        this.preventDuplicateAlertsRepository = preventDuplicateAlertsRepository;
    }
}
