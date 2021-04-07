package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.UserRepository;
import com.madura.flight.reservation.system.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;


    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/showReg")
    public String showRegistration() {
        return "login/registerUser";
    }

    @GetMapping("/login")
    public String showLogin(ModelMap modelMap) {
        modelMap.addAttribute("error", "");
        return "login/login";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password,
                            ModelMap modelMap) {
        User user = userRepository.findByEmail(email);

        if (user.getPassword().equals(password)) {
            return "findFlight";
        } else {
            modelMap.addAttribute("error", "Invalid User name or password");
        }
        return "login/login";
    }
}
