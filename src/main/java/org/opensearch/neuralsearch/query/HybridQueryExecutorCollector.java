/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.neuralsearch.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HybridQueryExecutorCollector<R, I> {

    private List<R> collection;
    private I input;

    public static <R, T> HybridQueryExecutorCollector newCollector(List<R> collection, T context) {
        return new HybridQueryExecutorCollector(collection, context);
    }

    public void collect(int index, Function<I, R> action) throws Exception {
        R result = action.apply(input);
        this.collection.add(index, result);
    }
}
