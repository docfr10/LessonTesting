package com.example.lesson_testing

import junit.framework.TestCase.assertTrue
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

    @Test(expected = NullPointerException::class)
    fun nullStringTest() {
        val str: String? = null
        assertTrue(str!!.isEmpty())
    }

    @Test(timeout = 1000)
    fun requestTest() {}

    @After
    fun tearDown() {
        calculator = null
    }
}