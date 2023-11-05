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

import com.leakyabstractions.result.api.Result;
import com.leakyabstractions.result.benchmark.exception.ComplexException;
import com.leakyabstractions.result.benchmark.exception.SimpleException;
import com.leakyabstractions.result.benchmark.failure.ComplexFailure;

/**
 * A service that invokes a {@link SimpleService} and transforms either its result or the raised error.
 *
 * @param simple The {@link SimpleService} to invoke.
 */
public record ComplexService(SimpleService simple) implements Service {

    /**
     * Creates a new instance.
     */
    public ComplexService() {
        this(new SimpleService());
    }

    /**
     * Returns a result that depends on a {@link SimpleService}.
     *
     * @param number Determines if the {@link SimpleService} should succeed or fail.
     * @return An uppercase {@code String} if the {@link SimpleService} succeeds.
     * @throws ComplexException if the {@link SimpleService} fails.
     */
    @Override
    public String usingExceptions(int number) throws ComplexException {
        try {
            return simple.usingExceptions(number).toUpperCase();
        } catch (SimpleException e) {
            throw new ComplexException(e);
        }
    }

    /**
     * Returns a result that depends on a {@link SimpleService}.
     *
     * @param number Determines if the {@link SimpleService} should succeed or fail.
     * @return A successful {@link Result} if the {@link SimpleService} succeeds; a failed {@link Result} otherwise.
     */
    @Override
    public Result<String, ComplexFailure> usingResults(int number) {
        return simple.usingResults(number)
                .map(String::toUpperCase, ComplexFailure::new);
    }
}
