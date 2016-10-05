package com.calculator.api;

import com.calculator.dto.dish.DishDTO;
import com.calculator.dto.dish.DishViewDTO;
import com.calculator.filter.DishFilter;
import com.calculator.model.Dish;
import com.calculator.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Get or set info about Dish
 */
@Api(value = "Dish", description = "Get, set, update or delete Dish")
@RestController
@RequestMapping("api/dish")
public class DishController extends BaseController {

    @Autowired
    private DishService dishService;

    @ApiOperation(value = "View info about Dish")
    @RequestMapping(value = "/{dishId}", method = RequestMethod.GET)
    public DishViewDTO getOne(
            @ApiParam(
                    name = "dishId", value = "The Id of dish", required = true
            )
            @PathVariable Long dishId) {
        Dish dish = dishService.findOne(dishId);
        return convertToDto(dish, DishViewDTO.class);
    }

    /**
     * Get info about all products
     *
     * @return Page<DishViewDTO>, info about all products
     */
    @ApiOperation(value = "View info about all dishes")
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public Page<DishViewDTO> getAll(
            @ApiParam(
                    name = "pageable", value = "Request parameters"
            )
                    Pageable pageable,
            @ApiParam(
                    name = "searchParams", value = "search parameters", required = true
            )
            @Valid @RequestBody DishFilter filter) {
        Page<Dish> dishes = dishService.findAll(filter, pageable);
        return dishes
                .map(source -> convertToDto(source, DishViewDTO.class));
    }

    @ApiOperation(value = "Create dish")
    @RequestMapping(method = RequestMethod.POST)
    public DishViewDTO create(
            @ApiParam(
                    name = "productDTO", value = "info about product to add"
            )
            @Valid @RequestBody DishDTO dishtDTO) {
        dishtDTO.setId(null);
        return convertToDto(dishService.create(convertToEntity(dishtDTO, Dish.class)), DishViewDTO.class);
    }
}
