package com.opmms.system.SmartOps.Maintenance.System.service.shift;

import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiRequestShift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiResponseShift;

public interface ShiftService {
    ApiResponseShift getAllShift();

    ApiResponseShift createShift(ApiRequestShift apiRequestShift);

    ApiResponseShift getShiftById(Long shiftId);

    ApiResponseShift updateShiftById(Long shiftId, ApiRequestShift apiRequestShift);

    ApiResponseShift deleteShiftById(Long shiftId);
}
