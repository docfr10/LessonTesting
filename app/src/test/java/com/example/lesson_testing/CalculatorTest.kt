package com.example.lesson_testing

import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    // Переменная для хранения экземпляра калькулятора
    private var calculator: Calculator? = null

    @Before
    fun setUp() {
        // Инициализируем экземпляр класса Calculator перед каждым тестом
        calculator = Calculator()
    }

    @Test
    fun addition() {
        // Тестируем метод adding с параметрами 1 и 2, ожидаем результат 3
        Assert.assertEquals(3, calculator!!.adding(1, 2).toLong())
    }

    @Test
    fun subtraction() {
        // Тестируем метод subtraction с параметрами 10 и 4, ожидаем результат 6
        Assert.assertEquals(6, calculator!!.subtraction(10, 4).toLong())
    }

    @Test
    fun multiplication() {
        // Тестируем метод multiplication с параметрами 3 и 7, ожидаем результат 21
        Assert.assertEquals(21, calculator!!.multiplication(3, 7).toLong())
    }

    @Test
    fun division() {
        // Тестируем метод division с параметрами 20 и 5, ожидаем результат 4
        Assert.assertEquals(4, calculator!!.division(20, 5).toLong())
    }

    @Test(expected = ArithmeticException::class)
    fun divisionByZero() {
        // Проверяем, что при делении на ноль выбрасывается ArithmeticException
        calculator!!.division(10, 0)
    }

    @Test
    fun addingNegativeNumbers() {
        // Тестируем сложение отрицательных чисел: (-5) + (-3) = -8
        Assert.assertEquals(-8, calculator!!.adding(-5, -3).toLong())
    }

    @Test
    fun addingLargeNumbers() {
        // Тестируем сложение больших чисел, проверяем на переполнение
        val largeNumber1 = Int.MAX_VALUE
        val largeNumber2 = 1
        val result = calculator!!.adding(largeNumber1, largeNumber2)
        // Ожидаем, что результат будет отрицательным из-за переполнения
        Assert.assertTrue(result < 0)
    }

    @Test
    fun nullStringTest() {
        // Проверяем, что NullPointerException выбрасывается при обращении к методу на null
        val str: String? = null
        assertTrue(str!!.isEmpty())
    }

    @Test(timeout = 1000)
    fun requestTest() {
        // Тестируем, что суммирование большого массива выполняется за 1000 миллисекунд
        val largeArray = IntArray(100_000_000) { it }
        var sum = 0
        for (number in largeArray) {
            sum += number
        }
        println("Сумма: $sum")
    }

    @Test
    fun testMultipleAdditions() {
        // Тестируем несколько случаев сложения
        Assert.assertEquals(0, calculator!!.adding(-2, 2).toLong())
        Assert.assertEquals(100, calculator!!.adding(70, 30).toLong())
        Assert.assertEquals(-1, calculator!!.adding(0, -1).toLong())
    }

    @After
    fun tearDown() {
        // Очищаем объект calculator после каждого теста
        calculator = null
    }
}