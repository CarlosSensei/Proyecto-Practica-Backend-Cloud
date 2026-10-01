package com.ccsw.tutorialloans.loan;

import com.ccsw.tutorialloans.loan.model.Loan;
import com.ccsw.tutorialloans.loan.model.LoanDto;
import com.ccsw.tutorialloans.loan.model.LoanSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoanService {

    Loan get(Long id);

    Page<Loan> findPage(LoanSearchDto dto);

    List<Loan> findAll();

    void save(Long id, LoanDto loanDto);

    void delete(Long id) throws Exception;
}
