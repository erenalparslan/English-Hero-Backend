package com.example.englishhero.English.Hero.repository;

import com.example.englishhero.English.Hero.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
