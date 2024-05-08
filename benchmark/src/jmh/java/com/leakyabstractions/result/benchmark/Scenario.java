/*
 * Copyright 2024 Guillermo Calvo
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

package com.leakyabstractions.result.benchmark;

import com.leakyabstractions.result.api.Result;
import com.leakyabstractions.result.benchmark.failure.Failure;
import com.leakyabstractions.result.benchmark.service.Service;
import com.leakyabstractions.result.benchmark.usecase.UseCase;

/**
 * Base class for all scenarios.
 * <p>
 * Supports these different scenarios:
 * <ol>
 *     <li>A {@link Service} that fails by throwing an {@link Exception}.</li>
 *     <li>A {@link Service} that fails by returning a {@link Failure} {@link Result}.</li>
 *     <li>A {@link Service} that succeeds by returning a {@code String}.</li>
 *     <li>A {@link Service} that succeeds by returning a {@code String} {@link Result}.</li>
 * </ol>
 */
abstract class Scenario {

    private final UseCase useCase;

    /**
     * Creates a new instance.
     *
     * @param useCase The {@link UseCase} to benchmark.
     */
    protected Scenario(UseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Executes the use case where a {@link Service} fails by throwing an {@link Exception}.
     *
     * @return The exception message.
     */
    protected String failureUsingExceptions() {
        return useCase.usingExceptions(UseCase.FAILURE);
    }

    /**
     * Executes the use case where a {@link Service} fails by returning a {@link Failure} {@link Result}.
     *
     * @return The failure message.
     */
    protected String failureUsingResults() {
        return useCase.usingResults(UseCase.FAILURE);
    }

    /**
     * Executes the use case where a {@link Service} succeeds by returning a {@code String}.
     *
     * @return The {@code String} returned by the service.
     */
    protected String successUsingExceptions() {
        return useCase.usingExceptions(UseCase.SUCCESS);
    }

    /**
     * Executes the use case where a {@link Service} succeeds by returning a {@code String} {@link Result}.
     *
     * @return The {@code String} returned by the service.
     */
    protected String successUsingResults() {
        return useCase.usingResults(UseCase.SUCCESS);
    }
}
