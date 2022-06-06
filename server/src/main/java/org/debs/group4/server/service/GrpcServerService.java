package org.debs.group4.server.service;

import com.google.protobuf.Empty;
import de.tum.i13.bandency.Batch;
import de.tum.i13.bandency.Benchmark;
import de.tum.i13.bandency.BenchmarkConfiguration;
import de.tum.i13.bandency.ChallengerGrpc;
import de.tum.i13.bandency.ResultQ1;
import de.tum.i13.bandency.ResultQ2;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.debs.group4.common.util.DummyUtil;

@Slf4j
@GrpcService
public class GrpcServerService extends ChallengerGrpc.ChallengerImplBase {

    @Override
    public void createNewBenchmark(BenchmarkConfiguration request, StreamObserver<Benchmark> responseObserver) {
        log.info(">>> createNewBenchmark");
        responseObserver.onNext(
            Benchmark.newBuilder()
                     .setId(1L)
                     .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void startBenchmark(Benchmark request, StreamObserver<Empty> responseObserver) {
        log.info(">>> startBenchmark");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void nextBatch(Benchmark request, StreamObserver<Batch> responseObserver) {
        log.info(">>> nextBatch");
        responseObserver.onNext(
            Batch.newBuilder()
                 .setSeqId(1L)
                 .setLast(true)
                 .addAllLookupSymbols(DummyUtil.getLookupSymbolList())
                 .addAllEvents(DummyUtil.getEventList())
                 .build()
        );

        responseObserver.onCompleted();
    }

    @Override
    public void resultQ1(ResultQ1 request, StreamObserver<Empty> responseObserver) {
        log.info(">>> resultQ1");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void resultQ2(ResultQ2 request, StreamObserver<Empty> responseObserver) {
        log.info(">>> resultQ2");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void endBenchmark(Benchmark request, StreamObserver<Empty> responseObserver) {
        log.info(">>> endBenchmark");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
