package com.opmms.system.SmartOps.Maintenance.System.repository;

import com.opmms.system.SmartOps.Maintenance.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

}
