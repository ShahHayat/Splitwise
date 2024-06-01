package com.makhdoom.Splitwise.repositories;

import com.makhdoom.Splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
}
