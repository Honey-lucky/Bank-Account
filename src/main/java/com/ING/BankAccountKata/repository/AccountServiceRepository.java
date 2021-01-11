package com.ING.BankAccountKata.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ING.BankAccountKata.domain.Account;



@Repository
public interface AccountServiceRepository extends CrudRepository<Account, Long>{

 

}
