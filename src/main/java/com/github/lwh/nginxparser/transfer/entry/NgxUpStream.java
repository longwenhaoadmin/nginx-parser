package com.github.lwh.nginxparser.transfer.entry;

import com.github.lwh.nginxparser.transfer.annotation.BlockValue;
import com.github.lwh.nginxparser.transfer.annotation.Param;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * upstream block
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 23 : 09
 */
@Data
@Accessors(chain = true)
public class NgxUpStream {

    @BlockValue
    private String name;

    @Param("server")
    private List<String> servers;

}
