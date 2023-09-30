package com.leakyabstractions.result.benchmark.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexUseCaseTest {

    final UseCase useCase = new ComplexUseCase();

    @Test
    public void testFailureUsingExceptions() {
        assertEquals("Complex error caused by: Simple error: -1", useCase.usingExceptions(UseCase.FAILURE));
    }

    @Test
    public void testFailureUsingResults() {
        assertEquals("Complex error caused by: Simple error: -1", useCase.usingResults(UseCase.FAILURE));
    }

    @Test
    public void testSuccessUsingExceptions() {
        assertEquals("OK", useCase.usingExceptions(UseCase.SUCCESS));
    }

    @Test
    public void testSuccessUsingResults() {
        assertEquals("OK", useCase.usingResults(UseCase.SUCCESS));
    }
}
