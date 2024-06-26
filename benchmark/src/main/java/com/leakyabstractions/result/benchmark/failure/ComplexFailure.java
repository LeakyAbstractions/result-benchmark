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

package com.leakyabstractions.result.benchmark.failure;

/**
 * A complex {@link Failure}.
 *
 * @param message The error message of this failure.
 * @param cause   The cause of this failure.
 */
public record ComplexFailure(String message, SimpleFailure cause) implements Failure {

    /**
     * Creates a new instance.
     *
     * @param cause The cause of this failure.
     */
    public ComplexFailure(SimpleFailure cause) {
        this("Complex error caused by: " + cause.message(), cause);
    }
}
