package com.rod.api.crawler;

import com.rod.api.common.AbstractRepository;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    @Getter
    private static CrawlerRepository instance = new CrawlerRepository();

    Map<String, ?> map;

    private CrawlerRepository(){
        this.map = new HashMap<>();
    }

    @Override
    public Map<String, Iterator<Element>> save(Map<String, ?> paramMap) throws IOException {
        Map<String, Iterator<Element>> musicChart = new HashMap<>();
        Document doc = Jsoup.connect(paramMap.get("URL") + "").timeout(10*1000).get();
        Elements element = doc.select(paramMap.get("table") + "");
        Iterator<Element> title = element.select(paramMap.get("title") + "").iterator();
        Iterator<Element> artist = element.select(paramMap.get("artist") + "").iterator();
        Iterator<Element> rank = element.select(paramMap.get("rank") + "").iterator();

        musicChart.put("title", title);
        musicChart.put("artist", artist);
        musicChart.put("rank", rank);

        map = musicChart;
        return musicChart;
    }
}