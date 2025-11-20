package com.pfm.user_service.dao;

import com.pfm.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByEmailId(String emailId);
}
