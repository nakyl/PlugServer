package com.plugserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.plugserver.domain.user_info;

public interface UserRepository extends JpaRepository<user_info, String> {

    @Query("SELECT u FROM user_info u WHERE LOWER(u.username) = LOWER(:username)")
    user_info findByUsernameCaseInsensitive(@Param("username") String username);

    @Query
    user_info findByEmail(String email);

    @Query
    user_info findByEmailAndActivationKey(String email, String activationKey);

    @Query
    user_info findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}