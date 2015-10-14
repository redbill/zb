package cn.com.hugedata.web.fsm.user.controller;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import cn.com.hugedata.web.fsm.user.model.UserInfo;
import cn.com.hugedata.web.fsm.user.service.UserService;
  
  
@RestController  
@RequestMapping("/users")  
public class UserController {  
	
	private static Logger logger = LoggerFactory
			.getLogger(UserController.class);
    @Resource  
    private UserService userService;  
      
//    @RequestMapping("/showUser")  
//    public String toIndex(HttpServletRequest request,Model model){  
//        int userId = Integer.parseInt(request.getParameter("id"));  
//        User user = this.userService.getUserById(userId);  
//        model.addAttribute("user", user);  
//        return "showUser";  
//    }
//    
    @RequestMapping("/{userId}")  
    public UserInfo showUser(@PathVariable int userId){  
    	logger.info("start process request users/userId");
        UserInfo user = this.userService.getUserById(userId);  
        return user;  
    } 
    
}