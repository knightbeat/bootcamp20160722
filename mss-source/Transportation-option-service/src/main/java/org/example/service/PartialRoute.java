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

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ck
 */
public class PartialRoute {
     
    private int part;
    private String from;
    private String to;
    private String option;
    private String identifier;

    public PartialRoute(int part, String from, String to, String option, String identifier) {
        this.part = part;
        this.from = from;
        this.to = to;
        this.option = option;
        this.identifier = identifier;
    }

    @XmlElement(name = "Part")
    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

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

    @XmlElement(name = "Option") 
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @XmlElement(name = "Identifier") 
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    
}
