package com.example.assignment.ui.solid

fun main() {
    val customerInfo = CustomerBalance()
    customerInfo.totalAmount=10
    customerInfo.tax=10
    customerInfo.calculateOrder()
    println("Your balance is ${customerInfo.balance}")
}
open class CalculateOrderOCP {
    var totalAmount: Int = 0
    var tax: Int = 0
    open fun calculateOrder() {
        val grandTotal = totalAmount + tax
        println("we prepared order for xyz and have grand total is $grandTotal")
    }
}
class CustomerBalance : CalculateOrderOCP() {
    var balance = 50
}


/**
 * One more example
 * */
abstract class Shape{
    abstract fun area()
}

class Circle : Shape() {
    override fun area() {
        println("calculate area of cirle")
    }
}
class Square : Shape() {
    override fun area() {
       println("calculate area of square")
    }

}
class CalculateArea(var shape: Shape) {
    fun calculate(){
        shape.area()
    }
}

