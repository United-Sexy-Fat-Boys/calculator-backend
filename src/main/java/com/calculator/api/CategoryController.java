package com.calculator.api;

import com.calculator.dto.category.CategoryDTO;
import com.calculator.dto.category.CategoryViewDTO;
import com.calculator.dto.user.AccountDTO;
import com.calculator.dto.user.AccountViewDTO;
import com.calculator.filter.CategoryFilter;
import com.calculator.model.Category;
import com.calculator.model.accounts.Account;
import com.calculator.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Get or set info about category
 */
@Api(value = "category", description = "Get, set, update or delete category")
@RestController
@RequestMapping("api/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "View info about category")
    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public CategoryViewDTO getOne(
            @ApiParam(
                    name = "categoryId", value = "The Id of category", required = true
            )
            @PathVariable Long categoryId) {
        Category a = categoryService.findOne(categoryId);
        return convertToDto(a, CategoryViewDTO.class);
    }

    /**
     * Get info about all accounts for admin
     *
     * @return Page<AccountViewDTO>, info about all accounts to display
     */
    @ApiOperation(value = "View info about category")
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public Page<CategoryViewDTO> getAll(
            @ApiParam(
                    name = "pageable", value = "Request parameters"
            )
                    Pageable pageable,
            @ApiParam(
                    name = "searchParams", value = "search parameters", required = true
            )
            @Valid @RequestBody CategoryFilter filter) {
        Page<Category> categories = categoryService.findAll(filter, pageable);
        return categories
                .map(source -> convertToDto(source, CategoryViewDTO.class));
    }

    @ApiOperation(value = "Create category")
    @RequestMapping(method = RequestMethod.POST)
    public CategoryViewDTO create(
            @ApiParam(
                    name = "categoryDTO", value = "info about category to add"
            )
            @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(null);
        return convertToDto(categoryService.create(convertToEntity(categoryDTO, Category.class)), CategoryViewDTO.class);
    }

}
