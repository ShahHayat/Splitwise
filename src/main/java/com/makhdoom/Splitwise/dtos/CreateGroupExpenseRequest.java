package com.makhdoom.Splitwise.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateGroupExpenseRequest {
    private String description;
    private double amount;
    private Long groupId;
    private List<Long> userIds = new ArrayList<>();
}
