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

package com.leakyabstractions.result.benchmark.usecase;

import com.leakyabstractions.result.api.Result;
import com.leakyabstractions.result.benchmark.failure.Failure;
import com.leakyabstractions.result.benchmark.service.Service;

/**
 * Base interface for all use cases.
 *
 * <p>
 * Use cases invoke a {@link Service} that will either succeed or fail.
 */
public interface UseCase {

    /**
     * A number that will make the {@link Service} fail.
     */
    int FAILURE = -1;

    /**
     * A number that will make the {@link Service} succeed.
     */
    int SUCCESS = 1;

    /**
     * Returns the {@link Service} this use case should invoke.
     *
     * @return The {@link Service} this use case should invoke.
     */
    Service service();

    /**
     * Invokes the {@link Service} that will either succeed or fail by throwing an {@link Exception}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A {@code String} representing either the success or the exception message.
     */
    default String usingExceptions(int number) {
        try {
            return service().usingExceptions(number);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Invokes the {@link Service} that will either succeed or fail by returning a {@link Failure} {@link Result}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A {@code String} representing either the success or the failure message.
     */
    default String usingResults(int number) {
        return service().usingResults(number).orElseMap(Failure::message);
    }
}
