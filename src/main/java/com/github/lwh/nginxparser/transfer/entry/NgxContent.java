package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.Param;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ngx配置文件起始类   nginx.conf
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 21 : 44
 */
@Data
@Accessors(chain = true)
public class NgxContent extends NgxCommon {

    /**
     * 工作进程数
     */
    @Param("worker_processes")
    private int workerProcesses;

    /**
     * 错误日志
     */
    @Param("error_log")
    private String errorLog;

    /**
     * 响应事件类型
     */
    @Param("events")
    private NgxEvents events;

    /**
     * http block
     */
    @Param("http")
    private List<NgxHttp> https = new ArrayList<>();

    public NgxContent addHttp(NgxHttp http) {
        this.https.add(http);
        return this;
    }

}
