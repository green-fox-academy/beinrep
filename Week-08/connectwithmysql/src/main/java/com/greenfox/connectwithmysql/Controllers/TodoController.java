package com.greenfox.connectwithmysql.Controllers;

import com.greenfox.connectwithmysql.Model.ToDo;
import com.greenfox.connectwithmysql.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

  @Autowired
  Repo repo;

  @GetMapping("/todo")
  public String todo() {
    repo.save(new ToDo("vakond"));
    return "/todo";
  }

  //@ResponseBody
  @GetMapping(value = {"", "/", "/list"})
  public String list(Model model, @RequestParam(value = "isActive", required = false) String isActive) {

    if (isActive == null || !isActive.equals("true")){
      model.addAttribute("todos", repo.findAll());
    }
    else {
      model.addAttribute("todos", repo.findByDone(false));
    }
    return "todolist";
  }

  @GetMapping(value = {"/list/add"})
  public String addList(Model model) {
    model.addAttribute("todo", new ToDo());
    return "addtodo";
  }
  @PostMapping(value = {"/list/add"})
  public String listAdded(ToDo todo) {
    repo.save(todo);
    return "redirect:/list";
  }
}

