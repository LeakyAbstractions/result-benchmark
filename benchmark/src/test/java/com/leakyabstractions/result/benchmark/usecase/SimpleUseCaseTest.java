package com.leakyabstractions.result.benchmark.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleUseCaseTest {

    final UseCase useCase = new SimpleUseCase();

    @Test
    public void testFailureUsingExceptions() {
        assertEquals("Simple error: -1", useCase.usingExceptions(UseCase.FAILURE));
    }

    @Test
    public void testFailureUsingResults() {
        assertEquals("Simple error: -1", useCase.usingResults(UseCase.FAILURE));
    }

    @Test
    public void testSuccessUsingExceptions() {
        assertEquals("ok", useCase.usingExceptions(UseCase.SUCCESS));
    }

    @Test
    public void testSuccessUsingResults() {
        assertEquals("ok", useCase.usingResults(UseCase.SUCCESS));
    }
}
