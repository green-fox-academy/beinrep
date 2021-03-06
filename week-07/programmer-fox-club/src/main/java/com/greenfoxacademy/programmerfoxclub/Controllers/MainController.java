package com.greenfoxacademy.programmerfoxclub.Controllers;

import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class MainController {

  private Map<String, Fox> foxes;

  MainController() {
    foxes = new HashMap<>();
    List<String> tricks = new ArrayList<String>(Arrays.asList("Write in Html", "Code in Java"));
    foxes.put("Mr. Fox", new Fox("Mr. Fox", "pizza", "lemonade", tricks));
  }

  @GetMapping("/")
  public String index(@RequestParam(value = "name", required = false) String name, Model model) {
    if (name == null || name.equals("")) {
      name = "Mr. Fox";
    }
    if (foxes.get(name) == null) {
      return "redirect:/login/?name=" + name;
    } else {
      Fox fox = foxes.get(name);
      model.addAttribute("fox", fox);
      return "index";
    }
  }

  @GetMapping("/login")
  public String showLogin(@RequestParam(value = "name", required = false) String name, Model model) {
    if (name == null) {
      name = "Name of fox";
      model.addAttribute("error", false);
    } else {
      model.addAttribute("error", true);
    }
    model.addAttribute("name", name);
    return "login";
  }

  @PostMapping("/login")
  public String submitLogin(@RequestParam("name") String name) {
    foxes.put(name, new Fox(name));
    return "redirect:/?name=" + name;
  }


  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam(value = "name", required = false) String name, Model model) {
    if (name == null || name.equals("")) {
      name = "Mr. Fox";
    }
    if (foxes.get(name) == null) {
      return "redirect:/login/?name=" + name;
    } else {
      Fox fox = foxes.get(name);
      model.addAttribute("fox", fox);
      return "nutritionStore";
    }
  }

  @PostMapping("/nutritionStore/{name}")
  public String changeNutrition(@RequestParam("food") String food, @RequestParam("drink") String drink, @PathVariable("name")String name) {
    foxes.get(name).setFood(food);
    foxes.get(name).setDrink(drink);
    foxes.put(name, foxes.get(name) );
    return "redirect:/?name=" + name;
  }
}
