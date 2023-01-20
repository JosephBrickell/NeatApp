package com.Neat.Transformer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;


public class BBCGoodFood {

    public static List<String> fetchIngregients(String url) throws IOException {
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();

        Elements div = doc.select("#__next > div.default-layout > main > div > div > div.layout-md-rail > " +
                "div.layout-md-rail__primary > div.post__content > div:nth-child(2) > div.row.recipe__instructions > " +
                "section.recipe__ingredients.col-12.mt-md.col-lg-6 > section > ul > li");

       return div.eachText();

    }

    public static List<String> fetchMethod(String url) throws IOException {
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();

        Elements methodDiv = doc.select("#__next > div.default-layout > main > div > div > div.layout-md-rail > " +
                "div.layout-md-rail__primary > div.post__content > div:nth-child(2) > div.row.recipe__instructions > " +
                "section.recipe__method-steps.mb-lg.col-12.col-lg-6 > div > ul > li");

        return methodDiv.eachText();
    }

}
