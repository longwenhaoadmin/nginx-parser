package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.Param;
import java.util.List;
import lombok.Data;

/**
 * server block
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 22 : 39
 */
@Data
public class NgxServer {

    @Param("listen")
    private List<String> listen;

    @Param("server_name")
    private String serverName;

    @Param("charset")
    private String charset;

    @Param("access_log")
    private String accessLog;

    @Param("ssl")
    private String ssl;

    @Param("ssl_certificate")
    private String sslCertificate;

    @Param("ssl_certificate_key")
    private String sslCertificateKey;

    @Param("ssl_session_cache")
    private String sslSessionCache;

    @Param("ssl_session_timeout")
    private String sslSessionTimeout;

    @Param("ssl_prefer_server_ciphers")
    private String sslPreferServerCiphers;

    @Param("ssl_ciphers")
    private String sslCiphers;

    @Param("location")
    private List<NgxLocation> locations;

}
