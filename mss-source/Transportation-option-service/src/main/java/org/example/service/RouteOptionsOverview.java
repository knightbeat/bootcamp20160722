/*
 * Copyright 2016 WSO2.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.service;

import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ck
 */
@XmlRootElement(name = "RouteOptionsList")
public class RouteOptionsOverview {

    private String from;
    private String to;
    private String at;
    private Collection<String> routeIds;

    @XmlElement(name = "From")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement(name = "To")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement(name = "At")
    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public RouteOptionsOverview(String from, String to, String at, Collection<String> routeIds) {
        this.from = from;
        this.to = to;
        this.at = at;
        this.routeIds = routeIds;
    }

    @XmlElement(name = "RouteID")
    public Collection<String> getRouteIds() {
        return routeIds;
    }

    public void setRouteIds(Collection<String> routeIds) {
        this.routeIds = routeIds;
    }

    public RouteOptionsOverview() {
    }
}
