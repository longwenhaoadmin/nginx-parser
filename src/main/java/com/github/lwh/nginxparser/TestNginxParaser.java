package com.github.lwh.nginxparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试使用解析器
 *
 * @author longwenhao
 * @version 1.0, 2021/5/20 11 : 32
 */
public class TestNginxParaser {


    public static void main(String[] args) throws IOException {

        //读取
        NgxConfig conf = NgxConfig.read("/Users/longwenhao/Downloads/nginx-1.14.2/conf/nginx.conf");

        //基本配置
        NgxParam workerProcesses = conf.findParam("worker_processes"); // Ex.2
        modify(workerProcesses,"auto");
        NgxParam errorLog = conf.findParam("error_log"); // Ex.2
        modify(errorLog,"logs/errors.log","debug");
        NgxParam listen = conf.findParam("http","server","listen"); // Ex.2
        modify(listen,"127.0.0.1","8080");

        //http配置
        NgxParam defaultType = conf.findParam("http","default_type"); // Ex.2
        modify(defaultType,"application/json");
        NgxParam keepaliveTimeout = conf.findParam("http","keepalive_timeout"); // Ex.2
        modify(keepaliveTimeout,"66");
        NgxParam accessLogSwitch = conf.findParam("http","access_log"); // Ex.2
        modify(accessLogSwitch,"on");
        NgxParam log_Format = conf.findParam("http","log_format"); // Ex.2
        modify(log_Format,"main","log_Format");
        NgxParam accessLog = conf.findParam("http","server","access_log"); // Ex.2
        modify(accessLog,"logs/access.log","main");

        //event配置
        NgxParam workerConnections = conf.findParam("events","worker_connections"); // Ex.2
        modify(workerConnections,"10240");
        NgxParam use = new NgxParam();
        use.addValue("use");
        use.addValue("epoll");
        conf.findBlock("events").addEntry(use);

        //负载均衡配置 （这个看了下产品，需要根据产品动态生成需要的配置）

        //输出
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);

    }


    /**
    * 修改对应节点的值
    *
    * @param param : 监听节点
    * @param values : 修改的值
    * @return void
    * @author longwenhao  2021/5/21 - 10:58 上午
    **/
    private static void modify(NgxParam param,String... values) {
        if(param == null){
            return;
        }
        //修改 （这个框架没有提供修改的入口，直接先删除value值，然后再添加，达到修改的目的）
        Iterator<NgxToken> it = param.getTokens().iterator();
        it.next();
        List remove = new ArrayList();
        while(it.hasNext()) {
            remove.add(it.next());
        }
        param.getTokens().removeAll(remove);
        for (String value:values) {
            param.addValue(value);
        }
    }

}
