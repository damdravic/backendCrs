package com.ddv.backendCrs.security.securityRepository;

import com.ddv.backendCrs.security.securityModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>  findByUsername(String username);

}
