package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    // 요청은 컨트롤러가 받는다 -> GetMapping이라는 어노테이션을 통해 받는다
    @GetMapping("/hi") // hi 라는 url을 입력받았을 때 greetings.mustache를 찾아서 보여준다
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "민정"); // 천재라는 값을 username이라는 이름에 연결시켜서 model이라는 객체가 보내줌
        return "greetings"; // templates/greetings.mustache 파일을 찾아서 브라우저로 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "민정");
        return "goodbye";
    }
}