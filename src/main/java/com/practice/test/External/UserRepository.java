package com.practice.test.External;

import com.practice.test.Domain.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
   Optional<UserEntity> findByName(String name);

   @Query("select u from UserEntity u where u.age = ?1")
   Optional<UserEntity> findAge(int age);


}