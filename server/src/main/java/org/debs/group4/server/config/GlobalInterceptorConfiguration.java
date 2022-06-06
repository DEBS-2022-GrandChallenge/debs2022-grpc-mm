package org.debs.group4.server.config;

import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.debs.group4.server.interceptor.LogGrpcInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GlobalInterceptorConfiguration {

    @GrpcGlobalServerInterceptor
    LogGrpcInterceptor logGrpcInterceptor() {
        return new LogGrpcInterceptor();
    }
}
