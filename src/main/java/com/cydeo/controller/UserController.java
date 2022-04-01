package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    @RequestMapping("/user")
    public class UserController {

        RoleService roleService;
        UserService userService;

        public UserController(RoleService roleService, UserService userService) {
            this.roleService = roleService;
            this.userService = userService;
        }

        @GetMapping("/create")
        public String createUser(Model model){

            model.addAttribute("user", new UserDTO());  //this is to create empty object (empty form)
            model.addAttribute("roles", roleService.findAll());  //bring me all roles from DB - business logic
            model.addAttribute("users", userService.findAll());

            return "/user/create";

        }

        @PostMapping("/create")
        public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

            model.addAttribute("user", new UserDTO()); //empty object need to be added (to show empty form in webpage)
            model.addAttribute("roles", roleService.findAll());  //bring me all roles from DB - business logic

            userService.save(user);
            model.addAttribute("users", userService.findAll());


 //           return "/user/create"; //create.html needs : user object (empty), roles attribute holding roles, users
            return "redirect:/user/create";

        }

@GetMapping("/update/{username}")
        public String editUser(@PathVariable("username") String username, Model model){

    model.addAttribute("user", userService.findById(username));
    model.addAttribute("roles", roleService.findAll());  //bring me all roles from DB - business logic
    model.addAttribute("users", userService.findAll());


            return "/user/update";

}

@PostMapping("/update")
public String updateUser(UserDTO user){


            userService.update(user);

            return "redirect:/user/create";
}

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        userService.deleteById(username);

        return "redirect:/user/create";
    }




}

