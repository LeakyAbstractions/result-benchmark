/*
 * Copyright 2023 Guillermo Calvo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leakyabstractions.result.benchmark.service;

import com.leakyabstractions.result.Result;
import com.leakyabstractions.result.benchmark.failure.Failure;

/**
 * Base interface for all services.
 *
 * @see SimpleService
 * @see ComplexService
 */
public interface Service {

    /**
     * Returns a result that ultimately depends on the given {@code number}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A {@code String} if the {@code number} is zero or greater.
     * @throws Exception if the {@code number} is less than zero.
     */
    String usingExceptions(int number) throws Exception;

    /**
     * Returns a result that ultimately depends on the given {@code number}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A successful {@link Result} if the {@code number} is zero or greater; a failed {@link Result} otherwise.
     */
    Result<String, ? extends Failure> usingResults(int number);
}
