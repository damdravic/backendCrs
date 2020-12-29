package com.ddv.backendCrs.security.securityRepository;

import com.ddv.backendCrs.security.securityModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {


}
