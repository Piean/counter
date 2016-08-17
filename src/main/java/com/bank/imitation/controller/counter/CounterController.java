package com.bank.imitation.controller.counter;

import com.bank.imitation.model.Counter;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by mogu on 2016/8/15.
 */
@Controller
@RequestMapping("/counter")
public class CounterController {
    @Resource
    private ICounterService counterService;

    @RequestMapping("/index")
    public String goIndex(String userName, String userPass) {
        return "login.html";
    }

    @RequestMapping("/login")
    public String counterLogin(Model model, String userName, String userPass, HttpSession session) {
        Counter counter = (Counter) session.getAttribute("counter");
        if (null == counter) {
            if (StringUtils.isNoneBlank(userName, userPass)) {
                Result<Counter> result = counterService.getByNameAndPass(userName, userPass);
                if (result.isSuccess() && result.getModel() != null) {
                    session.setAttribute("counter",counter);
                    model.addAttribute("message", "登录成功");
                    model.addAttribute(counter);
                    return "index";
                } else {
                    model.addAttribute("message", "登录失败，用户名或密码错误");
                    return "login";
                }
            } else {
                model.addAttribute("message", "登录失败，用户名或密码为空");
                return "login";
            }
        } else {
            model.addAttribute("message", "登录成功");
            model.addAttribute(counter);
            return "index";
        }
    }
}
