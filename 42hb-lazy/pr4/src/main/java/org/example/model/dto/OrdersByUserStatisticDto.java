package org.example.model.dto;

public class OrdersByUserStatisticDto {
    private String userName;
    private long counterOfOrders;

    public OrdersByUserStatisticDto(String userName, long counterOfOrders) {
        this.userName = userName;
        this.counterOfOrders = counterOfOrders;
    }
}
