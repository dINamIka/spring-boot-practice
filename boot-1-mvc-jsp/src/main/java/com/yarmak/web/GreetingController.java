package com.yarmak.web;

import com.yarmak.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class GreetingController {

    private static Collection<Item> getStockItems() {
        final Set<Item> items = new HashSet<>();
        items.add(new Item("dm_0001", "android device", BigDecimal.valueOf(3.5)));
        items.add(new Item("rf_0003", "ios device", BigDecimal.valueOf(4.5)));
        items.add(new Item("df_0234", "gaming console", BigDecimal.valueOf(55.5)));
        items.add(new Item("gm_0044", "windows laptop", BigDecimal.valueOf(432.5)));
        return items;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(final Model model) {
        return "hello";
    }


    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ModelAndView getData() {
        final ModelAndView modelAndView = new ModelAndView("data");
        modelAndView.addObject("items", getStockItems());
        return modelAndView;
    }
}
