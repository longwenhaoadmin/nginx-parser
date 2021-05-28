package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.Param;
import java.util.List;
import lombok.Data;

/**
 * http block
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 22 : 33
 */
@Data
public class NgxHttp {

    @Param("include")
    private String include;

    @Param("default_type")
    private String defaultType;

    @Param("log_format")
    private String logFormat;

    @Param("access_log")
    private String accessLog;

    @Param("sendfile")
    private String sendFile;

    @Param("tcp_nopush")
    private String tcpNoPush;

    @Param("keepalive_timeout")
    private String keepaliveTimeout;

    @Param("gzip")
    private String gzip;

    @Param("server")
    private List<NgxServer> servers;

    @Param("upstream")
    private List<NgxUpStream> upStreams;

}
