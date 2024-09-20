import co.thedebater.common.OrderEvent
import common.request.OrderEventDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface OrderRequestMapper {
    fun dtoToEvent(orderEventDto: OrderEventDto): OrderEvent
}