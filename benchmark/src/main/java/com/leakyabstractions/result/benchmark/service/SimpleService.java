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
import com.leakyabstractions.result.core.Results;
import com.leakyabstractions.result.benchmark.exception.SimpleException;
import com.leakyabstractions.result.benchmark.failure.SimpleFailure;

/**
 * A service that either returns a {@code String} or fails.
 */
public record SimpleService() implements Service {

    /**
     * Returns a result that depends on the given {@code number}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A {@code String} if the {@code number} is zero or greater.
     * @throws SimpleException if the {@code number} is less than zero.
     */
    @Override
    public String usingExceptions(int number) throws SimpleException {
        if (number < 0) {
            throw new SimpleException(number);
        }
        return "ok";
    }

    /**
     * Returns a result that depends on the given {@code number}.
     *
     * @param number Determines if the service should succeed or fail.
     * @return A successful {@link Result} if the {@code number} is zero or greater; a failed {@link Result} otherwise.
     */
    @Override
    public Result<String, SimpleFailure> usingResults(int number) {
        if (number < 0) {
            return Results.failure(new SimpleFailure(number));
        }
        return Results.success("ok");
    }
}
