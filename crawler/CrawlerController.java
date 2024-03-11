package com.rod.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrawlerController {
    private final CrawlerServiceImpl service = CrawlerServiceImpl.getInstance();
    public Map<String,?> findBugsMusic() throws IOException {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL", "https://music.bugs.co.kr/chart");
        paramMap.put("table", "table.byChart");
        paramMap.put("title", "p.title");
        paramMap.put("artist", "p.artist");
        paramMap.put("rank", "strong");
        return service.findNamesFromWeb(paramMap);
    }
    public Map<String,?> findMelonMusic() throws IOException {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL", "https://www.melon.com/chart/");
        paramMap.put("table", "tbody");
        paramMap.put("title", "div.ellipsis.rank01 > span");
        paramMap.put("artist", "div.ellipsis.rank02 > span");
        paramMap.put("rank", "td span.rank");
        return service.findNamesFromWeb(paramMap);
    }
}