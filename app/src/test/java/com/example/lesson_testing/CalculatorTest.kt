package com.example.lesson_testing

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private var calculator: Calculator? = null

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addition() {
        Assert.assertEquals(3, calculator!!.adding(1, 2).toLong())
    }

    @After
    fun tearDown() {
        calculator = null
    }
}