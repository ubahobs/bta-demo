package com.bta.base;

import com.bta.utils.Config;

public class PageBase {

    protected int timeout;

    protected PageBase() {
        timeout = Integer.parseInt(Config.getProp("long.timeout"));
    }
}
