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
package org.sonatype.goodies.dropwizard.util;

import java.util.Locale;

import javax.annotation.Nullable;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * String helpers.
 *
 * @since 1.0.2
 */
public final class MoreStrings
{
  private MoreStrings() {
    // empty
  }

  /**
   * Returns {@code true} if the given string is null or trimmed is the empty string.
   *
   * @since ???
   */
  @Nullable
  public static String blankToNull(@Nullable final String value) {
    if (value != null) {
      return Strings.emptyToNull(value.trim());
    }
    return null;
  }

  /**
   * Returns lower-case {@link Locale#ENGLISH} string.
   */
  public static String lower(final String value) {
    checkNotNull(value);
    return value.toLowerCase(Locale.ENGLISH);
  }

  /**
   * Returns upper-case {@link Locale#ENGLISH} string.
   */
  public static String upper(final String value) {
    checkNotNull(value);
    return value.toUpperCase(Locale.ENGLISH);
  }
}
