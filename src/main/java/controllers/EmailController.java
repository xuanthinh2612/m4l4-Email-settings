package controllers;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class EmailController {

    @GetMapping("/settings")
    public ModelAndView showSetting() {
        ModelAndView modelAndView = new ModelAndView("settingForm");
        modelAndView.addObject("email", new Email());
        modelAndView.addObject("languages", new String[]{"japanese", "english", "vietnamese", "chinese"});
        modelAndView.addObject("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        modelAndView.addObject("spamFilter", false);
        modelAndView.addObject("signature","");

        return modelAndView;
    }

    @PostMapping("/settings")
    public ModelAndView showInfo(@ModelAttribute Email email){
        return new ModelAndView("showInfo","email",email);
    }
}
