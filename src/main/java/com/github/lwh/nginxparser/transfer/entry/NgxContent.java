package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.Param;
import lombok.Data;

/**
 * ngx配置文件起始类   nginx.conf
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 21 : 44
 */
@Data
public class NgxContent {

    /**
     * 工作进程数
     */
    @Param("worker_processes")
    private String workerProcesses;

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

}
