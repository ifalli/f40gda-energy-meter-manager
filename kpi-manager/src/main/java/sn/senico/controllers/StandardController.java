package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.StandardService;
import sn.senico.user.model.Standard;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class StandardController {

    @Autowired
    private StandardService standardService;

    @ApiOperation(value = "Create standard", notes = "An standard is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/standard", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Standard createStandard(
        @ApiParam(value = "Standard to create", required = true) @Valid @RequestBody Standard standard) {

        /* Creating standard */
        standard = standardService.save(standard);

        return standard;

    }

    @ApiOperation(value = "Read a standard by its Id", notes = "A standard is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No standard found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/standard/{standardId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Standard> readStandardName(
        @ApiParam(value = "Name of the standard", required = true) @PathVariable(value = "standardId") Long standardId) {

        /* Getting standard */
        Optional<Standard> standard = standardService.findOne(standardId);

        return standard;
    }

    @ApiOperation(value = "Read al standards", notes = "A standard is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No standard found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/standards", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Standard> readStandards(Pageable pageable) {

        /* Getting standard */
        Page<Standard> standard = standardService.findAll(pageable);

        return standard;
    }

    @ApiOperation(value = "Update a standard", notes = "Change standard description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/standards/{standardId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateStandard(
        @ApiParam(value = "Standard identifier to update", required = true) @PathVariable("standardId") Long standardId,
        @Valid
        @ApiParam(value = "Standard to update", required = true) @RequestBody Standard standard) {

        log.debug("updateStandard start - standard: {}", standard);

        /* Setting standard ID */
        standard.setId(standardId);

        /* Updating standard */
        standardService.save(standard);

        log.debug("updateStandard end ok - standardId: {}", standard.getId());
    }

    @ApiOperation(value = "Delete a standard", notes = "Delete the standard in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Standard is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No standard found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/standard/{standardId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteStandard(
        @ApiParam(value = "Standard identifier", required = true) @PathVariable(value = "standardId") Long standardId) {

        log.debug("deleteStandard start - standardId: {}", standardId);

        /* Deleting standard */
        standardService.delete(standardId);

        log.debug("deleteStandard end ok - standardId: {}", standardId);

    }
}
