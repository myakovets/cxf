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
package org.apache.cxf.systest.type_test.soap;

import javax.xml.namespace.QName;

import org.apache.cxf.systest.type_test.AbstractTypeTestClient5;

import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

public class SOAPRpcLitClientTypeTest extends AbstractTypeTestClient5 {
    protected static final String WSDL_PATH = "/wsdl/type_test/type_test_rpclit_soap.wsdl";

    protected static final QName SERVICE_NAME = new QName("http://apache.org/type_test/rpc", "SOAPService");

    protected static final QName PORT_NAME = new QName("http://apache.org/type_test/rpc", "SOAPPort");
    static final String PORT = SOAPRpcLitServerImpl.PORT;

    @Before
    public void updatePort() throws Exception {
        updateAddressPort(rpcClient, PORT);
    }

    @BeforeClass
    public static void startServers() throws Exception {
        boolean ok = launchServer(SOAPRpcLitServerImpl.class, true);
        assertTrue("failed to launch server", ok);
        initClient(AbstractTypeTestClient5.class, SERVICE_NAME, PORT_NAME, WSDL_PATH);
    }

}
