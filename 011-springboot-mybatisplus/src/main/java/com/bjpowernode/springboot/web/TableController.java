package com.bjpowernode.springboot.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@MapperScan("com.bjpowernode.springboot.mapper")
public class TableController {

    @Resource
    UserServiceImpl userService;

    @GetMapping("/table")
    public String tableQuery(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        List<User> userList = userService.list();

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 3);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);

        model.addAttribute(userList);
        model.addAttribute(page);
        return "table";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id, @RequestParam(value = "pn",defaultValue = "1")Integer pn, RedirectAttributes ra){ //添加参数
        userService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/table";
    }
}
