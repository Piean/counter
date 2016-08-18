package com.bank.imitation.controller.counter;

import com.bank.imitation.model.Counter;
import com.bank.imitation.result.Result;
import com.bank.imitation.service.ICounterService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
        Counter counter = (Counter) session.getAttribute(session.getId());
        if (null == counter) {
            if (StringUtils.isNoneBlank(userName, userPass)) {
                Result<Counter> result = counterService.getByNameAndPass(userName, userPass);
                if (result.isSuccess() && result.getModel() != null) {
                    Counter counterResult = result.getModel();
                    counterResult.setLastLoginTime((int) (System.currentTimeMillis()/1000));
                    Result<Boolean> result1 = counterService.updateCounter(counterResult);
                    if (result1.isSuccess() && result1.getModel()) {
                        session.setAttribute(session.getId(),counterResult);
                        model.addAttribute("message", "登录成功");
                        model.addAttribute(counterResult);
                        return "index";
                    } else {
                        model.addAttribute("message", "登录失败");
                        return "login";
                    }
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

    @RequestMapping("login_out")
    public String counterLoginOut(HttpSession session, String id) {
        Counter counter = (Counter) session.getAttribute(session.getId());

        if (null == counter) {
            Result<Counter> result = counterService.getById(id);
            if (result.isSuccess() && result.getModel() != null) {
                counter = result.getModel();
                counter.setLastLeaveTime(counter.getLastLoginTime() + session.getMaxInactiveInterval());
                counterService.updateCounter(counter);
            }
        } else {
            counter.setLastLeaveTime((int) (System.currentTimeMillis()/1000));
            counterService.updateCounter(counter);
        }

        session.removeAttribute(session.getId());
        return "login";
    }

    @ResponseBody
    @RequestMapping("change_pass")
    public Map changePass(String id, String oldPass, String newPass) {
        Map map = new HashedMap();
        if (StringUtils.isAnyBlank(id,oldPass,newPass)) {
            map.put("message","用户名，原密码，新密码均不能为空");
            return map;
        }

        Result<Counter> result = counterService.getById(id);

        if (result.isSuccess() && result.getModel() != null) {
            Counter counter = result.getModel();

            if (!StringUtils.equals(counter.getUserPass(),oldPass)) {
                map.put("message","修改失败，原密码错误");
                return map;
            }

            counter.setUserPass(newPass);

            if (counterService.updateCounter(counter).getModel()) {
                map.put("message","修改密码成功");
                return map;
            } else {
                map.put("message","修改密码失败");
                return map;
            }
        } else {
            map.put("message","修改密码失败，用户不存在");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("change_info")
    public Map changeInfo(Counter counter) {
        Map map = new HashedMap();

        Result<Boolean> result = counterService.updateCounter(counter);

        if (result.isSuccess() && result.getModel()) {
            map.put("message","修改信息成功");
        } else {
            map.put("message","修改信息失败");
        }

        return map;
     }
}
