package com.sys.controller;
import com.sys.persistence.domain.User;
import com.sys.service.Impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {
    static Logger log = Logger.getLogger(UserController.class.getName());
    //处理业务逻辑的userService
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request){
        //获取所有的用户信息
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList", userList);
        return "user";
    }

    @RequestMapping("/showUserToJspById")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取所有的用户信息
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
