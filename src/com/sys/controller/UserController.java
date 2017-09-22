package com.sys.controller;
import com.module.spider.persistence.dao.MusicDao;
import com.sys.persistence.domain.User;
import com.sys.service.Impl.UserServiceImpl;
import com.sys.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
     * 0是登录失败 1是登录成功
     * @param account the account
     * @param userId  the user id
     * @param session the session
     * @return the int
     */
    @RequestMapping("/addUser")
    public @ResponseBody int  addUser(@RequestParam("account") String account,
                                 @RequestParam("userId") int userId,
                                 HttpSession session){
        int success=0;
        try{
            User user=userService.getUserById(userId);
            if(user==null){
                user=new User();
                user.setAccount(account);
                user.setUserId(userId);
                userService.addUser(user);
                success= 1;
            }
            session.setAttribute("userSession",user);
        }catch (Exception e){
            success= 0;
        }
        return success;
    }

}
