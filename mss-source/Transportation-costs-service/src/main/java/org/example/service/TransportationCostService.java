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
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "transport-cost")
@SwaggerDefinition(
        info = @Info(
                title = "Travel Routes Swagger Definition", version = "1.0",
                description = "TravelRoutesCostsService",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(
                        name = "Chathura Kulasinghe",
                        email = "chathurak@wso2.com",
                        url = "http://wso2.com"
                ))
)
@Path("/transport-cost")
public class TransportationCostService {

    @GET
    @Path("/rail")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Get cost on rail",
            notes = "Returns average ticket cost between two railway stations")

    public Cost getCostForRail(@ApiParam(value = "Start destination", required = true) @QueryParam("from") String from,
            @ApiParam(value = "End destination", required = true) @QueryParam("to") String to) {
        System.out.println("GET all invoked");
        System.out.println("From " + from + " to " + to);
        return new Cost("GBP", 12.56);
    }

    @GET
    @Path("/bus")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Get cost for Bus",
            notes = "Returns average ticket cost between two locations")

    public Cost getCostForBus(@ApiParam(value = "Start destination", required = true) @QueryParam("from") String from,
            @ApiParam(value = "End destination", required = true) @QueryParam("to") String to) {
        System.out.println("GET all invoked");
        System.out.println("From " + from + " to " + to);
        return new Cost("GBP", 45.87);
    }

    @GET
    @Path("/taxi")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Get taxi cost",
            notes = "Returns average taxi cost between two locations")
    public Cost getCostForTaxi(@ApiParam(value = "Start destination", required = true) @QueryParam("from") String from,
            @ApiParam(value = "End destination", required = true) @QueryParam("to") String to) {
        System.out.println("GET all invoked");
        System.out.println("From " + from + " to " + to);
        return new Cost("GBP", 230.25);
    }
}
