/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.neuralsearch.query;

import java.io.IOException;
import java.util.List;

public interface HybridQueryExecutorCollectorManager<C extends HybridQueryExecutorCollector, K> {
    C newCollector(final List<K> supplier) throws IOException;
}
