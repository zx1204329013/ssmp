package com.zhangxu.ssmp.controller.utils;

import lombok.Data;

@Data
public class AxiosResult {
    private boolean status;
    private boolean serverStatus = true;
    private Object data;

    public AxiosResult() {
    }

    public AxiosResult(boolean status) {
        this.status = status;
    }

    public AxiosResult(boolean status, boolean serverStatus) {
        this.status = status;
        this.serverStatus = serverStatus;
    }

    public AxiosResult(boolean status, boolean serverStatus, Object data) {
        this.status = status;
        this.serverStatus = serverStatus;
        this.data = data;
    }
}
