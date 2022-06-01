package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.StopSubCategoryService;
import sn.senico.user.model.StopSubCategory;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class StopSubCategoryController {

    @Autowired
    private StopSubCategoryService stopSubCategoryService;

    @ApiOperation(value = "Create stopSubCategory", notes = "An stopSubCategory is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/stop-sub-category", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public StopSubCategory createStopSubCategory(
        @ApiParam(value = "StopSubCategory to create", required = true) @Valid @RequestBody StopSubCategory stopSubCategory) {

        /* Creating stopSubCategory */
        stopSubCategory = stopSubCategoryService.save(stopSubCategory);

        return stopSubCategory;

    }

    @ApiOperation(value = "Read a stopSubCategory by its Id", notes = "A stopSubCategory is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopSubCategory found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stopSubCategory/{stopSubCategoryId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<StopSubCategory> readStopSubCategoryName(
        @ApiParam(value = "Name of the stopSubCategory", required = true) @PathVariable(value = "stopSubCategoryId") Long stopSubCategoryId) {

        /* Getting stopSubCategory */
        Optional<StopSubCategory> stopSubCategory = stopSubCategoryService.findOne(stopSubCategoryId);

        return stopSubCategory;
    }

    @ApiOperation(value = "Read al stopSubCategories", notes = "A stopSubCategory is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopSubCategory found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stop-sub-categories", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<StopSubCategory> readStopSubCategories(Pageable pageable) {

        /* Getting stopSubCategory */
        Page<StopSubCategory> stopSubCategory = stopSubCategoryService.findAll(pageable);

        return stopSubCategory;
    }

    @ApiOperation(value = "Update a stopSubCategory", notes = "Change stopSubCategory description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/stopSubCategorys/{stopSubCategoryId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateStopSubCategory(
        @ApiParam(value = "StopSubCategory identifier to update", required = true) @PathVariable("stopSubCategoryId") Long stopSubCategoryId,
        @Valid
        @ApiParam(value = "StopSubCategory to update", required = true) @RequestBody StopSubCategory stopSubCategory) {

        log.debug("updateStopSubCategory start - stopSubCategory: {}", stopSubCategory);

        /* Setting stopSubCategory ID */
        stopSubCategory.setId(stopSubCategoryId);

        /* Updating stopSubCategory */
        stopSubCategoryService.save(stopSubCategory);

        log.debug("updateStopSubCategory end ok - stopSubCategoryId: {}", stopSubCategory.getId());
    }

    @ApiOperation(value = "Delete a stopSubCategory", notes = "Delete the stopSubCategory in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "StopSubCategory is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopSubCategory found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/stopSubCategory/{stopSubCategoryId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteStopSubCategory(
        @ApiParam(value = "StopSubCategory identifier", required = true) @PathVariable(value = "stopSubCategoryId") Long stopSubCategoryId) {

        log.debug("deleteStopSubCategory start - stopSubCategoryId: {}", stopSubCategoryId);

        /* Deleting stopSubCategory */
        stopSubCategoryService.delete(stopSubCategoryId);

        log.debug("deleteStopSubCategory end ok - stopSubCategoryId: {}", stopSubCategoryId);

    }
}
