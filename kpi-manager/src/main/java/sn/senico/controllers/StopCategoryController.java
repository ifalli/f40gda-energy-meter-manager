package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.StopCategoryService;
import sn.senico.user.model.StopCategory;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class StopCategoryController {

    @Autowired
    private StopCategoryService stopCategoryService;

    @ApiOperation(value = "Create stopCategory", notes = "An stopCategory is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/stop-category", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public StopCategory createStopCategory(
        @ApiParam(value = "StopCategory to create", required = true) @Valid @RequestBody StopCategory stopCategory) {

        /* Creating stopCategory */
        stopCategory = stopCategoryService.save(stopCategory);

        return stopCategory;

    }

    @ApiOperation(value = "Read a stopCategory by its Id", notes = "A stopCategory is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopCategory found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stopCategory/{stopCategoryId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<StopCategory> readStopCategoryName(
        @ApiParam(value = "Name of the stopCategory", required = true) @PathVariable(value = "stopCategoryId") Long stopCategoryId) {

        /* Getting stopCategory */
        Optional<StopCategory> stopCategory = stopCategoryService.findOne(stopCategoryId);

        return stopCategory;
    }

    @ApiOperation(value = "Read al stop categories", notes = "A stopCategory is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopCategory found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stop-categories", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<StopCategory> readStopCategories(Pageable pageable) {

        /* Getting stopCategory */
        Page<StopCategory> stopCategory = stopCategoryService.findAll(pageable);

        return stopCategory;
    }

    @ApiOperation(value = "Update a stopCategory", notes = "Change stopCategory description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/stopCategorys/{stopCategoryId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateStopCategory(
        @ApiParam(value = "StopCategory identifier to update", required = true) @PathVariable("stopCategoryId") Long stopCategoryId,
        @Valid
        @ApiParam(value = "StopCategory to update", required = true) @RequestBody StopCategory stopCategory) {

        log.debug("updateStopCategory start - stopCategory: {}", stopCategory);

        /* Setting stopCategory ID */
        stopCategory.setId(stopCategoryId);

        /* Updating stopCategory */
        stopCategoryService.save(stopCategory);

        log.debug("updateStopCategory end ok - stopCategoryId: {}", stopCategory.getId());
    }

    @ApiOperation(value = "Delete a stopCategory", notes = "Delete the stopCategory in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "StopCategory is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stopCategory found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/stopCategory/{stopCategoryId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteStopCategory(
        @ApiParam(value = "StopCategory identifier", required = true) @PathVariable(value = "stopCategoryId") Long stopCategoryId) {

        log.debug("deleteStopCategory start - stopCategoryId: {}", stopCategoryId);

        /* Deleting stopCategory */
        stopCategoryService.delete(stopCategoryId);

        log.debug("deleteStopCategory end ok - stopCategoryId: {}", stopCategoryId);

    }
}
