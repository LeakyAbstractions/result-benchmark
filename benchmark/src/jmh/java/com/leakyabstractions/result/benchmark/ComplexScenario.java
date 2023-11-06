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

package com.leakyabstractions.result.benchmark;

import com.leakyabstractions.result.benchmark.usecase.ComplexUseCase;

/**
 * Base class for all complex scenarios.
 * <p>
 * Simple scenarios use a {@link ComplexUseCase} that returns a {@code String} representing either the success or the error message.
 */
public abstract class ComplexScenario extends Scenario {

    /**
     * Creates a new instance.
     */
    public ComplexScenario() {
        super(new ComplexUseCase());
    }
}