package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.MachineService;
import sn.senico.user.model.Machine;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class MachineController {

    @Autowired
    private MachineService machineService;

    @ApiOperation(value = "Create machine", notes = "An machine is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/machine", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Machine createMachine(
        @ApiParam(value = "Machine to create", required = true) @Valid @RequestBody Machine machine) {

        /* Creating machine */
        machine = machineService.save(machine);

        return machine;

    }

    @ApiOperation(value = "Read a machine by its Id", notes = "A machine is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No machine found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/machine/{machineId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Machine> readMachineName(
        @ApiParam(value = "Name of the machine", required = true) @PathVariable(value = "machineId") Long machineId) {

        /* Getting machine */
        Optional<Machine> machine = machineService.findOne(machineId);

        return machine;
    }

    @ApiOperation(value = "Read al machines", notes = "A machine is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No machine found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/machines", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Machine> readMachines(Pageable pageable) {

        /* Getting machine */
        Page<Machine> machine = machineService.findAll(pageable);

        return machine;
    }

    @ApiOperation(value = "Read paginated anomalies by filters")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
            value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/machine", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Machine> readMachines(
        @ApiParam(value = "name", required = false) @RequestParam(value = "name", required = false) String name,
        @ApiParam(value = "description", required = false) @RequestParam(value = "description", required = false) String description,
        Pageable pageable) {

        /* Getting machineList */
        return null; //machineService.readMachinesByFilters(name, description, pageable);

    }

    @ApiOperation(value = "Update a machine", notes = "Change machine description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/machines/{machineId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateMachine(
        @ApiParam(value = "Machine identifier to update", required = true) @PathVariable("machineId") Long machineId,
        @Valid
        @ApiParam(value = "Machine to update", required = true) @RequestBody Machine machine) {

        log.debug("updateMachine start - machine: {}", machine);

        /* Setting machine ID */
        machine.setId(machineId);

        /* Updating machine */
        machineService.save(machine);

        log.debug("updateMachine end ok - machineId: {}", machine.getId());
    }

    @ApiOperation(value = "Delete a machine", notes = "Delete the machine in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Machine is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No machine found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/machine/{machineId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteMachine(
        @ApiParam(value = "Machine identifier", required = true) @PathVariable(value = "machineId") Long machineId) {

        log.debug("deleteMachine start - machineId: {}", machineId);

        /* Deleting machine */
        machineService.delete(machineId);

        log.debug("deleteMachine end ok - machineId: {}", machineId);

    }
}
