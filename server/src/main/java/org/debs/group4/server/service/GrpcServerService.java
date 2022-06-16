package org.debs.group4.server.service;

import com.google.protobuf.Empty;
import de.tum.i13.bandency.Batch;
import de.tum.i13.bandency.Benchmark;
import de.tum.i13.bandency.BenchmarkConfiguration;
import de.tum.i13.bandency.ChallengerGrpc;
import de.tum.i13.bandency.ResultQ1;
import de.tum.i13.bandency.ResultQ2;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.debs.group4.server.util.Constants;

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class GrpcServerService extends ChallengerGrpc.ChallengerImplBase {

    private final NextBatchService nextBatchService;

    @Override
    public void createNewBenchmark(BenchmarkConfiguration request, StreamObserver<Benchmark> responseObserver) {
        responseObserver.onNext(Benchmark.newBuilder()
                                         .setId(0L)
                                         .build());
        responseObserver.onCompleted();
    }

    @Override
    public void startBenchmark(Benchmark request, StreamObserver<Empty> responseObserver) {
        log.warn("===========================================================================================");
        log.warn("======================================== Start Benchmark ===================================");
        log.warn("===========================================================================================");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void nextBatch(Benchmark request, StreamObserver<Batch> responseObserver) {
        final long batchId = request.getId();
        final boolean isLast = batchId == Constants.LAST_FILE_INDEX;

        responseObserver.onNext(
            Batch.newBuilder()
                 .setSeqId(batchId)
                 .setLast(isLast)
                 .addAllLookupSymbols(nextBatchService.getRandomLookupSymbols())
                 .addAllEvents(nextBatchService.generateEventList(batchId))
                 .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void resultQ1(ResultQ1 request, StreamObserver<Empty> responseObserver) {
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void resultQ2(ResultQ2 request, StreamObserver<Empty> responseObserver) {
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void endBenchmark(Benchmark request, StreamObserver<Empty> responseObserver) {
        log.warn("===========================================================================================");
        log.warn("======================================== End Benchmark ===================================");
        log.warn("===========================================================================================");
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
