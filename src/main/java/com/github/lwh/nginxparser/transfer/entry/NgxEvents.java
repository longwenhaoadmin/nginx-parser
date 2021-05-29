package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.Param;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * events 实体
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 22 : 07
 */
@Data
@Accessors(chain = true)
public class NgxEvents {

    /**
     * 进程连接数量
     */
    @Param("worker_connections")
    private String workerConnections;

    /**
     * I/O 模型
     */
    @Param("use")
    private String mode;

}
