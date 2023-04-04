package com.pws.BankUseroopsDemonstration.repository;

import com.pws.BankUseroopsDemonstration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
