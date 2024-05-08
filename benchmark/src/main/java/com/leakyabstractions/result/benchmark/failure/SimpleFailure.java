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
 * A simple {@link Failure}.
 *
 * @param message The error message of this failure.
 */
public record SimpleFailure(String message) implements Failure {

    /**
     * Creates a new instance.
     *
     * @param number The negative number that caused this failure.
     */
    public SimpleFailure(int number) {
        this("Simple error: " + number);
    }
}
