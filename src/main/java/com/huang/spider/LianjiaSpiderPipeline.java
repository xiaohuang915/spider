package com.huang.spider;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/10/29 14:29
 */
public class LianjiaSpiderPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> name = resultItems.get("descripted");
        name.forEach(System.out::println);
    }
}
