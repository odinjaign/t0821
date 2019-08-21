package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 17:25
 */
@Controller
public class IndexController {


    @Autowired
    private SpringTemplateEngine templateEngine;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("jaign:" + i);
            u.setAge(21);
            users.add(u);
        }
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/email")
    public void email(HttpServletResponse response) throws IOException {
        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("position", "Java工程师");
        context.setVariable("salary", 99999);
        String email = templateEngine.process("email", context);
        ModelAndView view = new ModelAndView();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(email);
        Logger.getLogger("IndexController").info(email);
    }
}
