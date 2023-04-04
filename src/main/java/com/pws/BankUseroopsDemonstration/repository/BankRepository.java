package com.pws.BankUseroopsDemonstration.repository;

import com.pws.BankUseroopsDemonstration.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
