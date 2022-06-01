package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.StopService;
import sn.senico.user.model.Stop;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class StopController {

    @Autowired
    private StopService stopService;

    @ApiOperation(value = "Create stop", notes = "An stop is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/stop", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Stop createStop(
        @ApiParam(value = "Stop to create", required = true) @Valid @RequestBody Stop stop) {

        /* Creating stop */
        stop = stopService.save(stop);

        return stop;

    }

    @ApiOperation(value = "Read a stop by its Id", notes = "A stop is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stop found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stop/{stopId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Stop> readStopName(
        @ApiParam(value = "Name of the stop", required = true) @PathVariable(value = "stopId") Long stopId) {

        /* Getting stop */
        Optional<Stop> stop = stopService.findOne(stopId);

        return stop;
    }

    @ApiOperation(value = "Read al stop", notes = "A stop is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stop found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/stop", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Stop> readStop(Pageable pageable) {

        /* Getting stop */
        Page<Stop> stop = stopService.findAll(pageable);

        return stop;
    }

    @ApiOperation(value = "Update a stop", notes = "Change stop description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/stops/{stopId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateStop(
        @ApiParam(value = "Stop identifier to update", required = true) @PathVariable("stopId") Long stopId,
        @Valid
        @ApiParam(value = "Stop to update", required = true) @RequestBody Stop stop) {

        log.debug("updateStop start - stop: {}", stop);

        /* Setting stop ID */
        stop.setId(stopId);

        /* Updating stop */
        stopService.save(stop);

        log.debug("updateStop end ok - stopId: {}", stop.getId());
    }

    @ApiOperation(value = "Delete a stop", notes = "Delete the stop in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Stop is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No stop found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/stop/{stopId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteStop(
        @ApiParam(value = "Stop identifier", required = true) @PathVariable(value = "stopId") Long stopId) {

        log.debug("deleteStop start - stopId: {}", stopId);

        /* Deleting stop */
        stopService.delete(stopId);

        log.debug("deleteStop end ok - stopId: {}", stopId);

    }
}
