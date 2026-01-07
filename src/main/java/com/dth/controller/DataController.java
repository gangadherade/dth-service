package com.dth.controller;

import com.dth.model.ApiResponse;
import com.dth.model.DthData;
import com.dth.model.NumpyData;
import com.dth.service.DthDataService;
import com.dth.service.NumpyDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/data")
@Tag(name = "Data Management", description = "APIs for managing DTH and Numpy data")
public class DataController {

    @Autowired
    private NumpyDataService numpyDataService;

    @Operation(summary = "Get all Numpy data", description = "Retrieve all numpy data arrays stored in the system")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved numpy data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Autowired
    private DthDataService dthDataService;

    /**
     * GET endpoint to retrieve all numpy data
     */
    @GetMapping("/numpy-data")
    public ResponseEntity<ApiResponse> getNumpyData() {
        try {
            java.util.List<NumpyData> data = numpyDataService.getAllNumpyData();
            ApiResponse response = new ApiResponse(
                    200,
                    "Numpy data retrieved successfully",
                    data,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(
                    500,
                    "Error retrieving numpy data: " + e.getMessage(),
                    null,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    @Operation(summary = "Get all DTH data", description = "Retrieve all DTH (Data Transfer Hub) data records stored in the system")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved DTH data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
    })
    }

    /**
     * GET endpoint to retrieve all DTH data
     */
    @GetMapping("/dth-data")
    public ResponseEntity<ApiResponse> getDthData() {
        try {
            Map<Long, DthData> data = dthDataService.getAllDthData();
            ApiResponse response = new ApiResponse(
                    200,
                    "DTH data retrieved successfully",
                    data,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(
                    500,
    @Operation(summary = "Update DTH data", description = "Update an existing DTH data record with new values")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "DTH data updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request - ID is required"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "DTH data not found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponse> updateDthData(
            @RequestBody io.swagger.v3.oas.annotations.parameters.RequestBody(description = "DTH data with ID to update", required = true)),
                    null,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * POST endpoint to update DTH data
     */
    @PostMapping("/update-dth-data")
    public ResponseEntity<ApiResponse> updateDthData(@RequestBody DthData dthData) {
        try {
            if (dthData.getId() == null) {
                ApiResponse errorResponse = new ApiResponse(
                        400,
                        "Error: ID is required for update",
                        null,
                        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            DthData updatedData = dthDataService.updateDthData(dthData.getId(), dthData);

            if (updatedData == null) {
                ApiResponse errorResponse = new ApiResponse(
                        404,
                        "DTH data not found with ID: " + dthData.getId(),
                        null,
                        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }

            ApiResponse response = new ApiResponse(
                    200,
                    "DTH data updated successfully",
                    updatedData,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.ok(response);
    @Operation(summary = "Delete DTH data", description = "Delete a DTH data record by its ID")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "DTH data deleted successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request - ID is required"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "DTH data not found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponse> deleteDthData(
            @RequestParam @Parameter(description = "The ID of the DTH data to delete", required = true)
            ApiResponse errorResponse = new ApiResponse(
                    500,
                    "Error updating DTH data: " + e.getMessage(),
                    null,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * POST endpoint to delete DTH data
     */
    @PostMapping("/delete-dth-data")
    public ResponseEntity<ApiResponse> deleteDthData(@RequestParam Long id) {
        try {
            if (id == null) {
                ApiResponse errorResponse = new ApiResponse(
                        400,
                        "Error: ID is required for deletion",
                        null,
                        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            boolean deleted = dthDataService.deleteDthData(id);

            if (!deleted) {
                ApiResponse errorResponse = new ApiResponse(
                        404,
                        "DTH data not found with ID: " + id,
                        null,
                        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }

            ApiResponse response = new ApiResponse(
                    200,
                    "DTH data deleted successfully",
                    "ID: " + id,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(
                    500,
                    "Error deleting DTH data: " + e.getMessage(),
                    null,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
