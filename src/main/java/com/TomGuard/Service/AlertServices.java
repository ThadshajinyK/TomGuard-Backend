
package com.TomGuard.Service;


import com.TomGuard.Model.Alert;

import java.util.List;

public interface AlertServices {
     void allAlerts();

    List<Alert> getAllAlerts();

    boolean deleteAlert(Long id);

    void deleteAll();
}
