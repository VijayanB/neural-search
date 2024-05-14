/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.neuralsearch.query;

import lombok.Getter;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ScorerSupplier;

import java.io.IOException;
import java.util.List;

public class ScoreSupplierCollectorManager
    implements
        HybridQueryExecutorCollectorManager<HybridQueryExecutorCollector<ScorerSupplier, LeafReaderContext>, ScorerSupplier> {
    @Getter
    private final LeafReaderContext context;

    public ScoreSupplierCollectorManager(LeafReaderContext context) {
        this.context = context;
    }

    /**
     * Return a new {@link HybridQueryExecutorCollector}. This must return a different instance on each call.
     */
    @Override
    public HybridQueryExecutorCollector<ScorerSupplier, LeafReaderContext> newCollector(final List<ScorerSupplier> supplier) {
        return HybridQueryExecutorCollector.newCollector(supplier, context);
    }
}
