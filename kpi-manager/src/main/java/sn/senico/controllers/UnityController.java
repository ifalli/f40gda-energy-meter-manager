package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.UnityService;
import sn.senico.user.model.Unity;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class UnityController {

    @Autowired
    private UnityService unityService;

    @ApiOperation(value = "Create unity", notes = "An unity is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/unity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Unity createUnity(
        @ApiParam(value = "Unity to create", required = true) @Valid @RequestBody Unity unity) {

        /* Creating unity */
        unity = unityService.save(unity);

        return unity;

    }

    @ApiOperation(value = "Read a unity by its Id", notes = "A unity is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No unity found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/unity/{unityId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Unity> readUnityName(
        @ApiParam(value = "Name of the unity", required = true) @PathVariable(value = "unityId") Long unityId) {

        /* Getting unity */
        Optional<Unity> unity = unityService.findOne(unityId);

        return unity;
    }

    @ApiOperation(value = "Read al unityUnityCategories", notes = "A unity is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No unity found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/unities", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Unity> readUnities(Pageable pageable) {

        /* Getting unity */
        Page<Unity> unity = unityService.findAll(pageable);

        return unity;
    }

    @ApiOperation(value = "Update a unity", notes = "Change unity description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/unitys/{unityId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateUnity(
        @ApiParam(value = "Unity identifier to update", required = true) @PathVariable("unityId") Long unityId,
        @Valid
        @ApiParam(value = "Unity to update", required = true) @RequestBody Unity unity) {

        log.debug("updateUnity start - unity: {}", unity);

        /* Setting unity ID */
        unity.setId(unityId);

        /* Updating unity */
        unityService.save(unity);

        log.debug("updateUnity end ok - unityId: {}", unity.getId());
    }

    @ApiOperation(value = "Delete a unity", notes = "Delete the unity in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Unity is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No unity found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/unity/{unityId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteUnity(
        @ApiParam(value = "Unity identifier", required = true) @PathVariable(value = "unityId") Long unityId) {

        log.debug("deleteUnity start - unityId: {}", unityId);

        /* Deleting unity */
        unityService.delete(unityId);

        log.debug("deleteUnity end ok - unityId: {}", unityId);

    }
}
