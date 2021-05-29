package com.github.lwh.nginxparser;

import com.github.lwh.nginxparser.ngx.NgxConfig;
import com.github.lwh.nginxparser.ngx.NgxDumper;
import com.github.lwh.nginxparser.ngx.NgxParam;
import com.github.lwh.nginxparser.ngx.NgxToken;
import com.github.lwh.nginxparser.transfer.converter.ConverterBeanFactory;
import com.github.lwh.nginxparser.transfer.entry.NgxContent;
import com.github.lwh.nginxparser.transfer.entry.NgxEvents;
import com.github.lwh.nginxparser.transfer.entry.NgxHttp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试使用解析器
 *
 * @author longwenhao
 * @version 1.0, 2021/5/20 11 : 32
 */
public class TestNginxParser {

    public static void main(String[] args) throws IllegalAccessException {
        NgxContent content = new NgxContent();
        content.setErrorLog("123");
        content.setWorkerProcesses(123);
        NgxEvents events = new NgxEvents();
        events.setMode("mode");
        events.setWorkerConnections("10240");
        content.setEvents(events);
        NgxHttp http = new NgxHttp();
        http.setAccessLog("aclog").setGzip("on");
        content.addHttp(http);
        content.addAttr("haha", "hehe");
        content.addAttr("http", http);
        NgxConfig block = new NgxConfig();
        ConverterBeanFactory.getConverter(content.getClass()).parser2conf(null, block, content);
        NgxDumper dumper = new NgxDumper(block);
        System.out.println(dumper.dump());
    }

    /**
     * 修改对应节点的值
     *
     * @param param : 监听节点
     * @param values : 修改的值
     * @return void
     * @author longwenhao  2021/5/21 - 10:58 上午
     **/
    private static void modify(NgxParam param, String... values) {
        if (param == null) {
            return;
        }
        //修改 （这个框架没有提供修改的入口，直接先删除value值，然后再添加，达到修改的目的）
        Iterator<NgxToken> it = param.getTokens().iterator();
        it.next();
        List remove = new ArrayList();
        while (it.hasNext()) {
            remove.add(it.next());
        }
        param.getTokens().removeAll(remove);
        for (String value : values) {
            param.addValue(value);
        }
    }
}
