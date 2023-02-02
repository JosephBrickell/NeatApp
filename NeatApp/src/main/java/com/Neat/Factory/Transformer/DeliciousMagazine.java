package com.Neat.Factory.Transformer;

import com.Neat.Factory.Website;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class DeliciousMagazine implements Website {

    @Override
    public List<String> fetchIngregients(String url) throws IOException {
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();

        Elements div = doc.select("#ingredients > div > ul > li");

        return div.eachText();

    }

    @Override
    public List<String> fetchMethod(String url) throws IOException {
        Connection conn = Jsoup.connect(url);

        Document doc = conn.get();

        Elements methodDiv = doc.select("#method > ol > li");

        return methodDiv.eachText();
    }

}
