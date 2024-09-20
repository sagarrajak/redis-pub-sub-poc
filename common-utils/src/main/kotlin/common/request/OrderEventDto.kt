package common.request

import com.fasterxml.jackson.annotation.JsonProperty

class OrderEventDto (
    @JsonProperty("order_id")
    val orderId: Int,
    @JsonProperty("user_id")
    val userId: Int,
    @JsonProperty("product_name")
    val productName: String?,
    @JsonProperty("price")
    val price: Int,
    @JsonProperty("quantity")
    val quantity: Int
)