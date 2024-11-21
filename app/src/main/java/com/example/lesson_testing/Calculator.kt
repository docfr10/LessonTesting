package com.example.lesson_testing

class Calculator {
    // Метод сложения двух целых чисел
    fun adding(a: Int, b: Int): Int {
        return a + b
    }

    // Метод вычитания двух целых чисел
    fun subtraction(a: Int, b: Int): Int {
        return a - b
    }

    // Метод умножения двух целых чисел
    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }

    // Метод деления двух целых чисел
    fun division(a: Int, b: Int): Int {
        // Проверка деления на ноль
        if (b == 0)
            throw ArithmeticException("Деление на ноль невозможно")
        return a / b
    }
}
