package com.makhdoom.Splitwise.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettleUpTransaction {
    private Long from;
    private Long to;
    private Double amount;
}
