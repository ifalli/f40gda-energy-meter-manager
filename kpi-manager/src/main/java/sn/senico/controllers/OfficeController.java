package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.OfficeService;
import sn.senico.user.model.Office;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @ApiOperation(value = "Create office", notes = "An office is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/office", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Office createOffice(
        @ApiParam(value = "Office to create", required = true) @Valid @RequestBody Office office) {

        /* Creating office */
        office = officeService.save(office);

        return office;

    }

    @ApiOperation(value = "Read a office by its Id", notes = "A office is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No office found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/office/{officeId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Office> readOfficeName(
        @ApiParam(value = "Name of the office", required = true) @PathVariable(value = "officeId") Long officeId) {

        /* Getting office */
        Optional<Office> office = officeService.findOne(officeId);

        return office;
    }

    @ApiOperation(value = "Read al offices", notes = "A office is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No office found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/offices", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Office> readOffices(Pageable pageable) {

        /* Getting office */
        Page<Office> office = officeService.findAll(pageable);

        return office;
    }

    @ApiOperation(value = "Update a office", notes = "Change office description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/offices/{officeId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateOffice(
        @ApiParam(value = "Office identifier to update", required = true) @PathVariable("officeId") Long officeId,
        @Valid
        @ApiParam(value = "Office to update", required = true) @RequestBody Office office) {

        log.debug("updateOffice start - office: {}", office);

        /* Setting office ID */
        office.setId(officeId);

        /* Updating office */
        officeService.save(office);

        log.debug("updateOffice end ok - officeId: {}", office.getId());
    }

    @ApiOperation(value = "Delete a office", notes = "Delete the office in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Office is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No office found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/office/{officeId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteOffice(
        @ApiParam(value = "Office identifier", required = true) @PathVariable(value = "officeId") Long officeId) {

        log.debug("deleteOffice start - officeId: {}", officeId);

        /* Deleting office */
        officeService.delete(officeId);

        log.debug("deleteOffice end ok - officeId: {}", officeId);

    }
}
