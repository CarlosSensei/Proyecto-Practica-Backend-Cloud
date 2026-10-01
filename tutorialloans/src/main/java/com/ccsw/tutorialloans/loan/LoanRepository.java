package com.ccsw.tutorialloans.loan;

import com.ccsw.tutorialloans.loan.model.Loan;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long>, JpaSpecificationExecutor<Loan> {

    List<Loan> findByClientId(Long id);

    List<Loan> findByGameId(Long id);
}
