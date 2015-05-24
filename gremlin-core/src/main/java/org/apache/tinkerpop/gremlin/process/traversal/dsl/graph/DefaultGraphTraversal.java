/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.process.traversal.dsl.graph;

import org.apache.tinkerpop.gremlin.process.traversal.Step;
import org.apache.tinkerpop.gremlin.process.traversal.util.DefaultTraversal;
import org.apache.tinkerpop.gremlin.structure.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DefaultGraphTraversal<S, E> extends DefaultTraversal<S, E> implements GraphTraversal.Admin<S, E> {

    public DefaultGraphTraversal() {
        super();
    }

    public DefaultGraphTraversal(final Graph graph) {
        super(graph);
    }

    @Override
    public GraphTraversal.Admin<S, E> asAdmin() {
        return this;
    }

    @Override
    public GraphTraversal<S, E> iterate() {
        return GraphTraversal.Admin.super.iterate();
    }

    @Override
    public boolean equals(final Object other) {
        return other != null && other.getClass().equals(this.getClass()) && this.asAdmin().equals(((DefaultGraphTraversal) other).asAdmin());
    }

    @Override
    public int hashCode() {
        int result = this.getClass().hashCode();
        for (final Step step : this.asAdmin().getSteps()) {
            result ^= step.hashCode();
        }
        return result;
    }

    @Override
    public DefaultGraphTraversal<S, E> clone() {
        return (DefaultGraphTraversal<S, E>) super.clone();
    }
}
