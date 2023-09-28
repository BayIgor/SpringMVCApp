package bay.spring.MVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false)String name,
                            Model model){
        model.addAttribute("message", "Hello " + name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calc(@RequestParam(value = "a", required = false, defaultValue = "0")double a,
                       @RequestParam(value = "b", required = false, defaultValue = "0")double b,
                       @RequestParam(value = "action", required = false, defaultValue = "")String action,
                       Model model){
        double result;
        switch (action){
            case "add":{
                result = a + b;
                break;
            }
            case "sub":{
                result = a - b;
                break;
            }
            case "mul":{
                result = a * b;
                break;
            }
            case "div":{
                result = a / b;
                break;
            }
            default: {
                result = 0;
                model.addAttribute("err", "Wrong action");
                break;
            }
        }
        model.addAttribute("ans", result);
        return "first/calculate";
    }
}
