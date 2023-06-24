
package com.TomGuard.Service;


import com.TomGuard.Model.Alert;

import java.util.List;

public interface AlertServices {
//     void cpuUsageAlert();
//     void memoryUsageAlert();
//     void diskUsageAlert();
//     void threadUsageAlert();
//     void numberOfSessionsUsageAlert();
//     void responseTimeAlert();
//     void requestTimeAlert();
//     void uptimeAlert();
//     void availabilityAlert();
     void allAlerts();

    List<Alert> getAllAlerts();

    boolean deleteAlert(Long id);
}
