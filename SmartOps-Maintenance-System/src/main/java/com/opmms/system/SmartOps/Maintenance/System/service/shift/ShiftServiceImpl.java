package com.opmms.system.SmartOps.Maintenance.System.service.shift;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.model.Shift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiRequestShift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiResponseShift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.InformationShift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ShiftData;
import com.opmms.system.SmartOps.Maintenance.System.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponseShift getAllShift()
    {
        List<InformationShift> informationShifts = shiftRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return buildResponse(200,informationShifts,"shift data fetched successfully");
    }

    @Override
    public ApiResponseShift createShift(ApiRequestShift apiRequestShift) {

        Shift shift = modelMapper.map(apiRequestShift, Shift.class);
        Shift savedShift = shiftRepository.save(shift);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedShift)),"shift created successfully");
    }

    @Override
    public ApiResponseShift getShiftById(Long shiftId) {

        Shift shift=findByIdOrThrow(shiftId);
        return buildResponse(200,Collections.singletonList(mapToInfo(shift)),"shift data fetched successfully");
    }

    @Override
    public ApiResponseShift updateShiftById(Long shiftId, ApiRequestShift apiRequestShift) {

        Shift shift = findByIdOrThrow(shiftId);
        shift.setShiftName(apiRequestShift.getShiftName());
        shift.setStartTime(apiRequestShift.getStartTime());
        shift.setEndTime(apiRequestShift.getEndTime());
        Shift updateShift = shiftRepository.save(shift);
        return buildResponse(200,Collections.singletonList(mapToInfo(updateShift)),"shift updated successfully");
    }

    @Override
    public ApiResponseShift deleteShiftById(Long shiftId) {

        Shift shift = findByIdOrThrow(shiftId);
        shiftRepository.delete(shift);
        return buildResponse(200,Collections.singletonList(mapToInfo(shift)),"shift deleted successfully");
    }

    private Shift findByIdOrThrow(Long shiftId) {
        return shiftRepository.findById(shiftId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.SHIFT,"shift not found"));
    }

    private InformationShift mapToInfo(Shift shift)
    {
        return modelMapper.map(shift, InformationShift.class);
    }

    private  ApiResponseShift buildResponse(int status, List<InformationShift> data,String message)
    {
        return new ApiResponseShift(status,new ShiftData(data==null? Collections.emptyList():data),message);
    }
}
