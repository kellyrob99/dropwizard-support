/*
 * Copyright (c) 2018-present Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.sonatype.goodies.dropwizard.testsupport;

import javax.ws.rs.core.Response;

import com.google.common.net.HttpHeaders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * JAX-RS {@link Response} assert helpers.
 *
 * @since ???
 */
public final class ResponseAssert
{
  private ResponseAssert() {
    // empty
  }

  public static void assertStatus(final Response response, final Response.Status status) {
    assertThat(response.getStatus(), is(status));
  }

  public static void assertContentType(final Response response, final String mediaType) {
    assertThat(response.getHeaderString(HttpHeaders.CONTENT_TYPE), is(mediaType));
  }
}