package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.BreakDownService;
import sn.senico.user.model.BreakDown;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class BreakDownController {

    @Autowired
    private BreakDownService breakDownService;

    @ApiOperation(value = "Create breakDown", notes = "An breakDown is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/breakDown", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public BreakDown createBreakDown(
        @ApiParam(value = "BreakDown to create", required = true) @Valid @RequestBody BreakDown breakDown) {

        /* Creating breakDown */
        breakDown = breakDownService.save(breakDown);

        return breakDown;

    }

    @ApiOperation(value = "Read a breakDown by its Id", notes = "A breakDown is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No breakDown found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/breakDown/{breakDownId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<BreakDown> readBreakDownName(
        @ApiParam(value = "Name of the breakDown", required = true) @PathVariable(value = "breakDownId") Long breakDownId) {

        /* Getting breakDown */
        Optional<BreakDown> breakDown = breakDownService.findOne(breakDownId);

        return breakDown;
    }

    @ApiOperation(value = "Read al breakDowns", notes = "A breakDown is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No breakDown found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/breakDowns", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<BreakDown> readBreakDowns(Pageable pageable) {

        /* Getting breakDown */
        Page<BreakDown> breakDown = breakDownService.findAll(pageable);

        return breakDown;
    }

    @ApiOperation(value = "Update a breakDown", notes = "Change breakDown description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/breakDowns/{breakDownId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateBreakDown(
        @ApiParam(value = "BreakDown identifier to update", required = true) @PathVariable("breakDownId") Long breakDownId,
        @Valid
        @ApiParam(value = "BreakDown to update", required = true) @RequestBody BreakDown breakDown) {

        log.debug("updateBreakDown start - breakDown: {}", breakDown);

        /* Setting breakDown ID */
        breakDown.setId(breakDownId);

        /* Updating breakDown */
        breakDownService.save(breakDown);

        log.debug("updateBreakDown end ok - breakDownId: {}", breakDown.getId());
    }

    @ApiOperation(value = "Delete a breakDown", notes = "Delete the breakDown in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "BreakDown is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No breakDown found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/breakDown/{breakDownId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteBreakDown(
        @ApiParam(value = "BreakDown identifier", required = true) @PathVariable(value = "breakDownId") Long breakDownId) {

        log.debug("deleteBreakDown start - breakDownId: {}", breakDownId);

        /* Deleting breakDown */
        breakDownService.delete(breakDownId);

        log.debug("deleteBreakDown end ok - breakDownId: {}", breakDownId);

    }
}
