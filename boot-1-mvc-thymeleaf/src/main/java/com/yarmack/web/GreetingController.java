package com.yarmack.web;

import com.yarmack.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getGreetingPage(final Model model) {
        //thymeleaf references and parses html files located in /resources/templates dir
        return "hello";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getSomeData(final Model model) {

        List<Item> items = new ArrayList<>();
        items.add(new Item("dm_0001", "android device", BigDecimal.valueOf(3.5)));
        items.add(new Item("rf_0003", "ios device", BigDecimal.valueOf(4.5)));
        items.add(new Item("df_0234", "gaming console", BigDecimal.valueOf(55.5)));
        items.add(new Item("gm_0044", "windows laptop", BigDecimal.valueOf(432.5)));
        model.addAttribute("data", items);

        return "data";
    }

}
