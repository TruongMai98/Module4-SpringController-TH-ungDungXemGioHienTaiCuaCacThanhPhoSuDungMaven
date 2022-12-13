package com.truongmai.springtimezonemaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping({"/", "/world-clock"})
    public String getTimeByTimezone(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_MInh") String city, ModelMap modelMap) {
        Date date = new Date(); // lay thoi gian hien tai
        System.out.println("------" + date);

        TimeZone local = TimeZone.getDefault(); // lay ra timezone hien tai
        System.out.println("------" + local);

        TimeZone locale = TimeZone.getTimeZone("Asia/Ho_Chi_Minh"); // lay ra timezone cua 1 thanh pho cu the
        System.out.println("------" + locale);

        long localTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset()); // tinh thoi  gian hien tai cua thanh pho cu the
        System.out.println("------" + localTime);

        date.setTime(localTime); // cai dat lai thoi gian cho bien "date" thanh thoi gian hien tai cua 1 thanh pho cu the
        System.out.println("------" + date);

        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date",date);
        return "index";
    }
}
