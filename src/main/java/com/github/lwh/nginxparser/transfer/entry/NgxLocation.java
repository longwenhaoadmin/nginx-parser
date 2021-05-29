package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.BlockValue;
import com.github.lwh.nginxparser.transfer.annotation.Param;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * location block
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 22 : 52
 */
@Data
@Accessors(chain = true)
public class NgxLocation {

    @BlockValue
    private String name;

    @Param("proxy_pass")
    private String proxyPass;

}
