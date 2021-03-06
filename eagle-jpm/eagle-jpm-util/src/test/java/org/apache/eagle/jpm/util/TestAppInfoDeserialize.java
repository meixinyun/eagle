/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eagle.jpm.util;

import org.apache.commons.io.IOUtils;
import org.apache.eagle.common.SerializableUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestAppInfoDeserialize {
    @Test
    public void testAppInfoDeserializeFromByteArray() throws IOException {
        InputStream appinfostream = this.getClass().getResourceAsStream("/appinfobytelong");
        //serialize allocatedMB as long byte deserializeto long
        byte[] bytes = IOUtils.toByteArray(appinfostream);
        Assert.assertNotNull(bytes);
        SerializableUtils.deserializeFromByteArray(bytes, "AppInfo Deserialize From ByteArray");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppInfoDeserializeFromByteArray1() throws IOException {
        InputStream appinfostream = this.getClass().getResourceAsStream("/appinfobyteint");
        //serialize allocatedMB as int byte deserialize to long
        byte[] bytes = IOUtils.toByteArray(appinfostream);
        SerializableUtils.deserializeFromByteArray(bytes, "AppInfo Deserialize From ByteArray");
    }
}
