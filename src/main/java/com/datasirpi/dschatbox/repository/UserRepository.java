package com.datasirpi.dschatbox.repository;

import com.datasirpi.dschatbox.dto.User;
import com.datasirpi.dschatbox.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long > {
}
