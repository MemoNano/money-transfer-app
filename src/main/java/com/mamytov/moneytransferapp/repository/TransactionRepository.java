package com.mamytov.moneytransferapp.repository;

import com.mamytov.moneytransferapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
