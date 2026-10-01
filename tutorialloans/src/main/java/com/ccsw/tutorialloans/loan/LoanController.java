package com.ccsw.tutorialloans.loan;

import com.ccsw.tutorialloans.client.ClientClient;
import com.ccsw.tutorialloans.client.model.ClientDto;
import com.ccsw.tutorialloans.game.GameClient;
import com.ccsw.tutorialloans.game.model.GameDto;
import com.ccsw.tutorialloans.loan.model.Loan;
import com.ccsw.tutorialloans.loan.model.LoanDto;
import com.ccsw.tutorialloans.loan.model.LoanSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Loan", description = "Api of Loan")
@RequestMapping(value = "/loan")
@RestController
public class LoanController {

    private final LoanService loanService;

    private final ModelMapper mapper;

    private final ClientClient clientClient;
    private final GameClient gameClient;

    public LoanController(LoanService loanService, ModelMapper mapper, ClientClient clientClient, GameClient gameClient) {
        this.loanService = loanService;
        this.mapper = mapper;
        this.clientClient = clientClient;
        this.gameClient = gameClient;
    }

    @Operation(summary = "FindPage", description = "Method to return a page of loans")
    @PostMapping
    public Page<LoanDto> findPage(@RequestBody LoanSearchDto dto) {

        Page<Loan> page = this.loanService.findPage(dto);

        List<ClientDto> clients = clientClient.findAll();
        List<GameDto> games = gameClient.findAll();

        return new PageImpl<>(
                page.getContent().stream().map(loan -> {

                    LoanDto loanDto = new LoanDto();

                    loanDto.setId(loan.getId());

                    loanDto.setClient(
                            clients.stream()
                                    .filter(client -> client.getId().equals(loan.getClientId()))
                                    .findFirst()
                                    .orElse(null)
                    );

                    loanDto.setGame(
                            games.stream()
                                    .filter(game -> game.getId().equals(loan.getGameId()))
                                    .findFirst()
                                    .orElse(null)
                    );

                    loanDto.setLoanDate(loan.getLoanDate());
                    loanDto.setReturnDate(loan.getReturnDate());

                    return loanDto;

                }).collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
    }

    @Operation(summary = "Update", description = "Method to update a loan")
    @PutMapping("/{id}")
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto loanDto) {

        this.loanService.save(id, loanDto);
    }

    @PutMapping
    public void save(@RequestBody LoanDto loanDto) {
        this.loanService.save(null, loanDto);
    }

    @Operation(summary = "Delete", description = "Method that deletes a Loan")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id", required = false) Long id) throws Exception {

        this.loanService.delete(id);

    }


}
