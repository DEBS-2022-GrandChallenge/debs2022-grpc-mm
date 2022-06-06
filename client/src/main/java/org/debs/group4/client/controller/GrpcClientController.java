package org.debs.group4.client.controller;

import lombok.RequiredArgsConstructor;
import org.debs.group4.client.service.GrpcClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/grpc")
@RequiredArgsConstructor
@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/benchmark")
    public String createNewBenchmark() {
        return grpcClientService.createNewBenchmark();
    }

    @GetMapping("/benchmark/start")
    public String startBenchmark() {
        return grpcClientService.startBenchmark();
    }

    @GetMapping("/batch")
    public String nextBatch() {
        return grpcClientService.nextBatch();
    }

    @GetMapping("/result/1")
    public String resultQ1() {
        return grpcClientService.resultQ1();
    }

    @GetMapping("/result/2")
    public String resultQ2() {
        return grpcClientService.resultQ2();
    }

    @GetMapping("/benchmark/end")
    public String endBenchmark() {
        return grpcClientService.endBenchmark();
    }
}
