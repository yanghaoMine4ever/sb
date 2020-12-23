package com.github.sb.config.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SbRequestInfo {

    private String clientIpProxy;

    private String clientIp;

    private String method;

    private String uri;

    private String contentType;

    private String requestParam;

}
