package com.ltc.employeemanagementsystemcodepolisspringlearning.repo;

import com.ltc.employeemanagementsystemcodepolisspringlearning.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
