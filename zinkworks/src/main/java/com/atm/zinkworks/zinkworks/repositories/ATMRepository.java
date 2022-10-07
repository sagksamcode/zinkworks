package com.atm.zinkworks.zinkworks.repositories;

import com.atm.zinkworks.zinkworks.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMRepository extends JpaRepository<Account, Integer> {

}
