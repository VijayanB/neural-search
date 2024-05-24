/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.neuralsearch.executors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;

import java.util.Optional;
import java.util.function.Function;

/**
 * {@link HybridQueryExecutorCollector} is a generic Collector used by Hybrid Search Query during
 * Query phase to parallelize sub query's action to improve latency
 */
@RequiredArgsConstructor(staticName = "newCollector")
public final class HybridQueryExecutorCollector<I, R> {

    private final I param;

    // getResult should only be called after collector's collect method is invoked.
    @Getter(onMethod_={@Synchronized})
    private Optional<R> result = Optional.empty();

    @Synchronized
    public void collect(Function<I, R> action) {
        result = Optional.ofNullable(action.apply(param));
    }
}
