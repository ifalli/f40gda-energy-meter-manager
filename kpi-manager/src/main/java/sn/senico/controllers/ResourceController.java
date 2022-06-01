package sn.senico.controllers;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.senico.annotations.F40gdaGatewayApi;
import sn.senico.services.ResourceService;
import sn.senico.user.model.Resource;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@CrossOrigin()
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "Create resource", notes = "An resource is ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")
    })
    @PostMapping(value = "/resource", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @F40gdaGatewayApi
    public Resource createResource(
        @ApiParam(value = "Resource to create", required = true) @Valid @RequestBody Resource resource) {

        /* Creating resource */
        resource = resourceService.save(resource);

        return resource;

    }

    @ApiOperation(value = "Read a resource by its Id", notes = "A resource is identified by its Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No resource found for the given name."),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/resource/{resourceId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Optional<Resource> readResourceName(
        @ApiParam(value = "Name of the resource", required = true) @PathVariable(value = "resourceId") Long resourceId) {

        /* Getting resource */
        Optional<Resource> resource = resourceService.findOne(resourceId);

        return resource;
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
    @GetMapping(value = "/resource", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @F40gdaGatewayApi
    public Page<Resource> readResources(
        @ApiParam(value = "name", required = false) @RequestParam(value = "name", required = false) String name,
        @ApiParam(value = "description", required = false) @RequestParam(value = "description", required = false) String description,
        Pageable pageable) {

        /* Getting resourceList */
        return resourceService.findAll(pageable);

    }

    @ApiOperation(value = "Update a resource", notes = "Change resource description and/or permissions")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/resources/{resourceId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void updateResource(
        @ApiParam(value = "Resource identifier to update", required = true) @PathVariable("resourceId") Long resourceId,
        @Valid
        @ApiParam(value = "Resource to update", required = true) @RequestBody Resource resource) {

        log.debug("updateResource start - resource: {}", resource);

        /* Setting resource ID */
        resource.setId(resourceId);

        /* Updating resource */
        resourceService.save(resource);

        log.debug("updateResource end ok - resourceId: {}", resource.getId());
    }

    @ApiOperation(value = "Delete a resource", notes = "Delete the resource in the module and the IAM if no one use it")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Resource is successfully deleted"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 404, message = "No resource found for the given identifier"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @DeleteMapping(value = "/resource/{resourceId}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @F40gdaGatewayApi
    public void deleteResource(
        @ApiParam(value = "Resource identifier", required = true) @PathVariable(value = "resourceId") Long resourceId) {

        log.debug("deleteResource start - resourceId: {}", resourceId);

        /* Deleting resource */
        resourceService.delete(resourceId);

        log.debug("deleteResource end ok - resourceId: {}", resourceId);

    }
}
