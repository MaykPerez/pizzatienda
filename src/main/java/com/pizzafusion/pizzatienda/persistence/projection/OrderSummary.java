package com.pizzafusion.pizzatienda.persistence.projection;

import java.time.LocalDateTime;

public interface OrderSummary {
    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderGlobal();
    String getPizzaName();
}
