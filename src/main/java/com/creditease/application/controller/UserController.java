package com.creditease.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.creditease.application.query.Pager;
import com.creditease.application.entity.User;
import com.creditease.application.query.ResultInfo;
import com.creditease.application.query.UserBean;
import com.creditease.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info")
    @ResponseBody
    public JSONObject userInfo(){

        User userInfo = userService.findUserInfo("chen", "chen");

        Object o = JSONObject.toJSON(userInfo);

        return (JSONObject) o;

    }

    @RequestMapping("/to/list")
    public String touser(HttpServletRequest request){
        return "user/userList";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userList(UserBean bean, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        Pager user = userService.findUserListByPage(bean);

        info.setRows(user.getResults());
        info.setTotal(user.getTotalResult());
        return info;
    }

}
