package com.opmms.system.SmartOps.Maintenance.System.service.downtime;

import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiRequestDowntime;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiResponseDowntime;
import org.springframework.http.HttpStatus;

public interface DowntimeService {
    ApiResponseDowntime getAllDowntime();

    ApiResponseDowntime createDowntime(Long machineId,Long userId,ApiRequestDowntime apiRequestDowntime);

    ApiResponseDowntime getDowntimeById(Long downtimeId);

    ApiResponseDowntime updateDowntimeById(Long downtimeId, ApiRequestDowntime apiRequestDowntime);

    ApiResponseDowntime deleteDowntimeById(Long downtimeId);
}
