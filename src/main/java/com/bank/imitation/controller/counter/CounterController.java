package com.bank.imitation.controller.counter;

import com.alibaba.fastjson.JSON;
import com.bank.imitation.model.Counter;
import com.bank.imitation.query.CounterQuery;
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
import java.util.List;
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
    public String goIndex() {
        return "login";
    }

    @RequestMapping("/login")
    public String counterLogin(Model model, String userName, String userPass, HttpSession session) {
        Counter counter = (Counter) session.getAttribute(session.getId());
        if (null == counter) {
            if (StringUtils.isNoneBlank(userName, userPass)) {
                Result<Counter> result = counterService.getByNameAndPass(userName, userPass);
                if (result.isSuccess() && result.getModel() != null) {
                    counter = result.getModel();
                    counter.setLastLoginTime((int) (System.currentTimeMillis()/1000));
                    Result<Boolean> result1 = counterService.updateCounter(counter);
                    if (result1.isSuccess() && result1.getModel()) {
                        session.setAttribute(session.getId(),counter);
                        model.addAttribute("message", "登录成功");
                        model.addAttribute(counter);
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
            session.setAttribute(session.getId(),counter);
            model.addAttribute("message", "登录成功");
            model.addAttribute(counter);
            return "index";
        }
    }

    @RequestMapping("login_out")
    public String counterLoginOut(HttpSession session) {
        Counter counter = (Counter) session.getAttribute(session.getId());
        if (counter != null) {
            counter.setLastLeaveTime((int) (System.currentTimeMillis() / 1000));
            counterService.updateCounter(counter);
            session.removeAttribute(session.getId());
        }
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
    public String changeInfo(Counter counter) {
        Result<Boolean> result = counterService.updateCounter(counter);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping("query_list")
    public String queryCounterList(CounterQuery query) {
        Result<List<Counter>> result = counterService.queryCounter(query);
        return JSON.toJSONString(result);
    }
}
