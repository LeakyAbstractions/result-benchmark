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

import com.leakyabstractions.result.Result;
import com.leakyabstractions.result.benchmark.exception.SimpleException;
import com.leakyabstractions.result.benchmark.failure.SimpleFailure;
import com.leakyabstractions.result.benchmark.service.SimpleService;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Compares performance when a {@link SimpleService} fails.
 * <p>
 * Contains these benchmarks:
 * <ol>
 *     <li>A {@link SimpleService} that fails by throwing a {@link SimpleException}.</li>
 *     <li>A {@link SimpleService} that fails by returning a {@link SimpleFailure} {@link Result}.</li>
 * </ol>
 */
@State(Scope.Benchmark)
public class SimpleFailureScenario extends SimpleScenario {

    /**
     * Benchmarks the use case where a {@link SimpleService} fails by throwing a {@link SimpleException}.
     *
     * @param bh A black hole.
     */
    @Benchmark
    public void exceptions(Blackhole bh) {
        bh.consume(failureUsingExceptions());
    }

    /**
     * Benchmarks the use case where a {@link SimpleService} fails by returning a {@link SimpleFailure} {@link Result}.
     *
     * @param bh A black hole.
     */
    @Benchmark
    public void results(Blackhole bh) {
        bh.consume(failureUsingResults());
    }
}
