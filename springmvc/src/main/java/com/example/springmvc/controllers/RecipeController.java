package com.example.springmvc.controllers;

import com.example.springmvc.models.Recipe;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springmvc.repositories.RecipeRepository;
import com.example.springmvc.repositories.RecipeRepositorywithoutJpa;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;

@Controller
public class RecipeController {
    
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeRepositorywithoutJpa recipeRepositorywithoutJpa ;

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/recipebook")
    public String recipe(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipebook";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "indexold";
    }


    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
    
    @RequestMapping("/save")
    public String save(@RequestParam String metric, @RequestParam int portionsize, @RequestParam String recipeName, @RequestParam String recipeDesc, @RequestParam String ing, @RequestParam String quant, @RequestParam String recipeCourse, @RequestParam String recipeImage) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setRecipeDesc(recipeDesc);
        recipe.setRecipeImage(recipeImage);
        recipe.setRecipeCourse(recipeCourse);
        recipe.setIng(ing);
        recipe.setQuant(quant);
        recipe.setPortionSize(portionsize);
        recipe.setMetric(metric);
        recipe.setCal();
        recipeRepository.save(recipe);
        return "redirect:/showrecipe/" + recipe.getId();
    }

    @RequestMapping("/upsave/{id}")
    public String upsave(@RequestParam String metric, @RequestParam int portionSize, @RequestParam String recipeName, @RequestParam String recipeDesc, @RequestParam String ing, @RequestParam String quant, @RequestParam String recipeCourse,  @RequestParam String recipeImage, Model model, @PathVariable Long id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        recipe.setRecipeName(recipeName);
        recipe.setRecipeDesc(recipeDesc);
        recipe.setRecipeImage(recipeImage);
        recipe.setRecipeCourse(recipeCourse);
        recipe.setIng(ing);
        recipe.setQuant(quant);
        recipe.setPortionSize(portionSize);
        recipe.setMetric(metric);
        recipe.setCal();
        recipeRepository.save(recipe);
        return "redirect:/recipebook/";
    }

    @RequestMapping("/showrecipe/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeRepository.findById(id).orElse(null));
        return "showrecipe";
    }

    @RequestMapping("/delete")
    public String deleteItem(@RequestParam Long id) {
        // Recipe recipe = recipeRepository.findById(id).orElse(null);
        // recipeRepository.delete(recipe);

        System.out.println(id);
        recipeRepositorywithoutJpa.deleteItem(id);
        return "redirect:/recipebook";
        
        //return "redirect:/recipebook";
        
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeRepository.findById(id).orElse(null));
        Recipe details = recipeRepository.findById(id).orElse(null);
        System.out.println(details.getPortionSize());
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam String metric, @RequestParam int portionsize, @RequestParam Long id, @RequestParam String recipeName, @RequestParam String recipeDesc, @RequestParam String ing, @RequestParam String quant, @RequestParam String recipeCourse, @RequestParam String recipeImage) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        recipe.setRecipeName(recipeName);
        recipe.setRecipeDesc(recipeDesc);
        recipe.setRecipeImage(recipeImage);
        recipe.setRecipeCourse(recipeCourse);
        recipe.setIng(ing);
        recipe.setQuant(quant);
        recipe.setMetric(metric);
        recipe.setPortionSize(portionsize);
        recipe.setCal();
        recipeRepository.save(recipe);
        return "redirect:/showrecipe/" + recipe.getId();
    }

    
    
}