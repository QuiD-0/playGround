package com.quid.spring.board.user.repository;

import com.quid.spring.board.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
