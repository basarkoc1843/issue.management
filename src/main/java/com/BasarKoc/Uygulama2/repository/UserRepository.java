package com.BasarKoc.Uygulama2.repository;

import com.BasarKoc.Uygulama2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
