package com.calculator.api;

import com.calculator.dto.product.ProductDTO;
import com.calculator.dto.product.ProductViewDTO;
import com.calculator.filter.ProductFilter;
import com.calculator.model.Product;
import com.calculator.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Get or set info about Product
 */
@Api(value = "product", description = "Get, set, update or delete product")
@RestController
@RequestMapping("api/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "View info about product")
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductViewDTO getOne(
            @ApiParam(
                    name = "productId", value = "The Id of product", required = true
            )
            @PathVariable Long productId) {
        Product a = productService.findOne(productId);
        return convertToDto(a, ProductViewDTO.class);
    }

    /**
     * Get info about all products
     *
     * @return Page<ProductViewDTO>, info about all products
     */
    @ApiOperation(value = "View info about all products")
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public Page<ProductViewDTO> getAll(
            @ApiParam(
                    name = "pageable", value = "Request parameters"
            )
                    Pageable pageable,
            @ApiParam(
                    name = "searchParams", value = "search parameters", required = true
            )
            @Valid @RequestBody ProductFilter filter) {
        Page<Product> products = productService.findAll(filter, pageable);
        return products
                .map(source -> convertToDto(source, ProductViewDTO.class));
    }

    @ApiOperation(value = "Create product")
    @RequestMapping(method = RequestMethod.POST)
    public ProductViewDTO create(
            @ApiParam(
                    name = "productDTO", value = "info about product to add"
            )
            @Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId(null);
        return convertToDto(productService.create(convertToEntity(productDTO, Product.class)), ProductViewDTO.class);
    }
}
