package com.huang.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/10/29 10:56
 */
public class LianjiaSpider implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    @Override
    public void process(Page page) {
        List<String> nameS = page.getHtml().xpath("//*[@id=\"content\"]/div[1]/ul/li/div[@class=\"info clear\"]/div[@class=\"title\"]/a/text()").all();
        page.putField("descripted", nameS);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new LianjiaSpider())
                .addUrl("https://cd.lianjia.com/ershoufang/")
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .addPipeline(new LianjiaSpiderPipeline())
                .run();
    }
}