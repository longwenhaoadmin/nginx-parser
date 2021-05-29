package com.github.lwh.nginxparser.antlr;

import com.github.lwh.nginxparser.ngx.NgxConfig;
import org.antlr.v4.runtime.misc.NotNull;


public class NginxListenerImpl extends NginxBaseListener {

    private NgxConfig result;

    public NgxConfig getResult() {
        return result;
    }

    @Override
    public void enterConfig(@NotNull NginxParser.ConfigContext ctx) {
        result = ctx.ret;
    }
}
