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
package com.sonatype.ossindex.dropwizard.security;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.dropwizard.jersey.errors.ErrorMessage;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import org.apache.shiro.authz.AuthorizationException;

/**
 * {@link AuthorizationException} exception-mapper.
 *
 * Converts exceptions to {@link ErrorMessage} for rendering.
 *
 * @since ???
 */
@Named
@Singleton
public class AuthorizationExceptionMapper
    extends LoggingExceptionMapper<AuthorizationException>
{
  @Override
  public Response toResponse(final AuthorizationException exception) {
    long id = logException(exception);
    Status status = Status.FORBIDDEN;
    ErrorMessage message = new ErrorMessage(status.getStatusCode(), formatErrorMessage(id, exception));

    return Response.status(status)
        .type(MediaType.APPLICATION_JSON_TYPE)
        .entity(message)
        .build();
  }

  @Override
  protected String formatErrorMessage(final long id, final AuthorizationException exception) {
    return String.format("Authorization failure. It has been logged (ID %016x).", id);
  }
}
