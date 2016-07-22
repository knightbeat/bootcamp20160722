/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "transport-options")
@SwaggerDefinition(
        info = @Info(
                title = "Travel Routes Swagger Definition", version = "1.0",
                description = "TravelRoutesOptionsService",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(
                        name = "Chathura Kulasinghe",
                        email = "chathurak@wso2.com",
                        url = "http://wso2.com"
                ))
)
@Path("/transport-options")
public class TransportationOptionService {
    
    private Map<String, RouteOption> routeOptions = new HashMap<>();

    public TransportationOptionService() {
        RouteOption routeOption1 = new RouteOption();
        PartialRoute part11 = new PartialRoute(1, "Hampton", "Waterloo", "Train", "Southwest Trains");
        PartialRoute part12 = new PartialRoute(2, "Waterloo", "Kennington Church", "Bus", "59");
        PartialRoute[] op1PartialRoutes = {part11, part12};
        routeOption1.setId("LNDN00012");
        routeOption1.setPartialRoutes(op1PartialRoutes);

        RouteOption routeOption2 = new RouteOption();
        PartialRoute part21 = new PartialRoute(1, "Hampton", "Waterloo", "Train", "Southwest Trains");
        PartialRoute part22 = new PartialRoute(2, "Waterloo", "Kennington Church", "Bus", "159");
        PartialRoute[] op2PartialRoutes = {part21, part22};
        routeOption2.setId("LNDN00013");
        routeOption2.setPartialRoutes(op2PartialRoutes);

        RouteOption routeOption3 = new RouteOption();
        PartialRoute part31 = new PartialRoute(1, "Hampton", "Vauxhaul", "Train", "Southwest Trains");
        PartialRoute part32 = new PartialRoute(2, "Vauxhaul", "Kennington Church", "Walk", "-");
        PartialRoute[] op3PartialRoutes = {part31, part32};
        routeOption3.setId("LNDN00014");
        routeOption3.setPartialRoutes(op3PartialRoutes);

        routeOptions.put(routeOption1.getId(), routeOption1);
        routeOptions.put(routeOption2.getId(), routeOption2);
        routeOptions.put(routeOption3.getId(), routeOption3);
    }
    @GET
    @Path("/routes")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Get all routes",
            notes = "Returns all route IDs")
    public RouteOptionsOverview getAllRoutes(@ApiParam(value = "Start destination", required = true) @QueryParam("from") String from,
            @ApiParam(value = "End destination", required = true) @QueryParam("to") String to,
            @ApiParam(value = "Start time", required = true) @QueryParam("at") String at) {
        System.out.println("GET all invoked");
        System.out.println("From " + from+" to "+to+" at "+at);
        
        return new RouteOptionsOverview(from, to, at, this.routeOptions.keySet());
    }

    @GET
    @Path("/routes/{routeId}")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Return fastest travel route options information against from, to and the time",
            notes = "Returns HTTP 404 if the route is not found")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Valid travel route option found"),
        @ApiResponse(code = 404, message = "Travel route option not found")})
    public RouteOption getRouteById(@ApiParam(value = "routeId", required = true)
            @PathParam("routeId") String routeId) {
        // TODO: Implementation for HTTP GET request
        System.out.println("GET invoked");

        return this.routeOptions.get(routeId);
    }

    @POST
    @Path("/routes")
    @Consumes("application/json")
    @ApiOperation(
            value = "Add route option",
            notes = "Adds route option to a collection")
    public void addRoute(@ApiParam(value = "Stock object", required = true) RouteOption routeOption) {
        System.out.println("Add route option");
        this.routeOptions.put(routeOption.getId(), routeOption);
    }
}
