package com.Neat.Controllers;

import com.Neat.Factory.Factory;
import com.Neat.Factory.Transformer.BBCGoodFood;
import com.Neat.Factory.Website;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class RecipeController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("")
    public String home() {

        return "landingPage";
    }

    @PostMapping("/response")
    public String response(@RequestBody String url, ModelMap model, ModelMap model2) throws IOException {

        String url2 = URLDecoder.decode(url, StandardCharsets.UTF_8).replace("url=", "");


        int startIndex = url.indexOf("www.") + 4; // 4 is the length of "www."
        int endIndex = url.indexOf(".co");
        String subString = url.substring(startIndex, endIndex);

        Website website = Factory.createInstance(subString);

        if (website != null){
            List<String> ingredients = website.fetchIngregients(url2);
            List<String> method = website.fetchMethod(url2);

            model.addAttribute("ingredients", ingredients);
            model2.addAttribute("method", method);
        }
        return "response";
    }

//    @PostMapping("/response2")
//    public String getResponse(@RequestBody String url) throws IOException {
//
//        String url2 = URLDecoder.decode(url, "UTF-8");
//
//        List<String> ingredients = BBCGoodFood.fetchIngregients(url2.replace("url=", ""));
//
//        List<String> method = BBCGoodFood.fetchMethod(url2.replace("url=", ""));
//
//        Recipe recipe = new Recipe(ingredients, method);
//        return objectMapper.writeValueAsString(recipe);
//    }

}
