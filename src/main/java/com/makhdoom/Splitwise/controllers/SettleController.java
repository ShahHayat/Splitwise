package com.makhdoom.Splitwise.controllers;

import com.makhdoom.Splitwise.services.SettleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class SettleController {

    private SettleService settleService;

    public void settleUp(Long groupId) {
        settleService.settleUp(groupId);
    }
}
