package com.opmms.system.SmartOps.Maintenance.System.repository;

import com.opmms.system.SmartOps.Maintenance.System.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Long> {
}
