/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.jaxrs.exception;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.Parameter;
import org.apache.cxf.jaxrs.model.ParameterType;

public class ParamException extends ClientErrorException {
    private final Parameter parameter;

    public ParamException(Parameter parameter, Response response, Throwable cause) {
        super(response, cause);
        this.parameter = parameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public ParameterType getParameterType() {
        return this.parameter.getType();
    }

    public String getParameterName() {
        return this.parameter.getName();
    }

    public String getDefaultStringValue() {
        return this.parameter.getDefaultValue();
    }
}
