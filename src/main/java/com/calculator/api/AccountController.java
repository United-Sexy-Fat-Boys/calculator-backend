package com.calculator.api;

import com.calculator.dto.user.AccountDTO;
import com.calculator.dto.user.AccountViewDTO;
import com.calculator.filter.account.AccountFilter;
import com.calculator.model.accounts.Account;
import com.calculator.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Get or set info about account
 */
@Api(value = "accounts", description = "Get, set, update or delete info about accounts")
@RestController
@RequestMapping("api/accounts")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * Get info about one account
     *
     * @param accountId courseId
     * @return AccountViewDTO, info about account to display
     */
    @ApiOperation(value = "View info about course")
    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public AccountViewDTO getOne(
            @ApiParam(
                    name = "accountId", value = "The Id of account", required = true
            )
            @PathVariable Long accountId) {
        Account a = accountService.findOne(accountId);
        return convertToDto(a, AccountViewDTO.class);
    }

    /**
     * Get info about all accounts for admin
     *
     * @return Page<AccountViewDTO>, info about all accounts to display
     */
    @ApiOperation(value = "View info about accounts for admin")
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public Page<AccountViewDTO> getAll(
            @ApiParam(
                    name = "pageable", value = "Request parameters"
            )
                    Pageable pageable,
            @ApiParam(
                    name = "searchParams", value = "search parameters", required = true
            )
            @Valid @RequestBody AccountFilter filter) {
        Page<Account> accounts = accountService.findAll(filter, pageable);
        return accounts
                .map(source -> convertToDto(source, AccountViewDTO.class));
    }

    /**
     * Create one account
     *
     * @param accountDTO info about account
     * @return AccountViewDTO, info about account to display
     */
    @ApiOperation(value = "Create account")
    @RequestMapping(method = RequestMethod.POST)
    public AccountViewDTO create(
            @ApiParam(
                    name = "accountDTO", value = "info about account to add"
            )
            @Valid @RequestBody AccountDTO accountDTO) {
        accountDTO.setId(null);
        return convertToDto(accountService.create(convertToEntity(accountDTO, Account.class)), AccountViewDTO.class);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void signout() {
        //for sign in
    }
}
