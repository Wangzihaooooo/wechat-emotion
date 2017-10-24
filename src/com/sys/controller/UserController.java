package com.sys.controller;

import com.sys.persistence.domain.User;
import com.sys.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type User controller.
 */
@Controller
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class.getName());
    //处理业务逻辑的userService
    @Resource
    private UserService userService;

    /**
     * Add user int.
     * @param account the account
     * @param openId  the open id
     * @param session the session
     * @return the int
     */
    @RequestMapping("/checkUser")
    public @ResponseBody String  addUser(HttpServletRequest request,
                                      @RequestParam("account") String account,
                                      @RequestParam("openId") String openId,
                                      HttpSession session){

        try{
            User user=userService.getUserByOpenId(openId);
            if(user==null){
                user=new User();
                user.setAccount(account);
                user.setOpenId(openId);
                userService.addUser(user);
            }
            session.setAttribute("userSession",user);
            return session.getId();
        }catch (Exception e){
            return null;
        }
    }

}
