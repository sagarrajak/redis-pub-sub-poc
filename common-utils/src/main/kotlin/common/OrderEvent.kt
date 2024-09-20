package co.thedebater.common


data class OrderEvent  (
    val orderId: Int,
    val userId: Int,
    val productName: String?,
    val price: Int,
    val quantity: Int
)