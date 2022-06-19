package com.example.assignment.ui.solid
/**
 * https://medium.com/flutter-community/s-o-l-i-d-the-first-5-principles-of-object-oriented-design-with-dart-f31d62135b7e
* */
/**
 * Single Responsibility principle
 **/
fun main() {
    val customerInfo=CustomerInfo("Abhinav")
     val order = CalculateOrder(100, 5,customerInfo)
     order.calculateOrder()
}
class CustomerInfo(var name: String = "")

class CalculateOrder(private var totalAmount: Int, private var tax: Int,var customerInfo:CustomerInfo) {
    fun calculateOrder() {
        val grandTotal = totalAmount + tax
        println("we prepared order for ${customerInfo.name} and have grand total is $grandTotal")
    }
}
