package com.rod.api.crawler;

import lombok.Getter;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    @Getter
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    private final CrawlerRepository repository;
    Map<String, ?> map;
    private CrawlerServiceImpl(){
        repository = CrawlerRepository.getInstance();
        this.map = new HashMap<>();
    }

    @Override
    public  Map<String, ?> findNamesFromWeb( Map<String, String> paramMap) throws IOException {
        Map<String, Iterator<Element>> music = repository.save(paramMap);
        Map<String, String> musicLank = new HashMap<>();
        Iterator<Element> title = music.get("title");
        Iterator<Element> artist = music.get("artist");
        Iterator<Element> rank = music.get("rank");
        while (rank.hasNext()) {
            System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
        }
        map = musicLank;
        return map;
    }

}