/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math.analysis.solvers;


/** The kinds of solutions that a {@link UnivariateRealSolver (univariate real)
 * root-finding algorithm} may accept as solutions. This basically controls
 * whether or not under-approximations and over-approximations are allowed.
 *
 * <p>If all solutions are accepted ({@link #EITHER_SIDE}), then the solution
 * that the root-finding algorithm returns for a given root may be equal to the
 * actual root, but it may also be an approximation that is slightly smaller
 * or slightly larger than the actual root. Root-finding algorithms generally
 * only guarantee that the returned solution is within the requested
 * tolerances. In certain cases however, in particular for
 * {@link EventHandler state events} of {@link ODEIntegrator ODE solvers}, it
 * may be necessary to guarantee that a solution is returned that does not
 * under-approximate the solution.</p>
 *
 * @see BracketedSolution
 * @since 3.0
 * @version $Id$
 */
public enum AllowedSolutions {
    /** There are no additional side restriction on the solutions for
     * root-finding. That is, both under-approximations and over-approximations
     * are allowed. So, if a function f(x) has a root at x = y, then the
     * root-finding result s may be smaller than y, equal to y, or greater
     * than y.
     */
    EITHER_SIDE,

    /** Only solutions that are less than or equal to the actual root are
     * acceptable as solutions for root-finding. In other words,
     * over-approximations are not allowed. So, if a function f(x) has a root
     * at x = y, then the root-finding result s must satisfy s &lt;= y.
     */
    LEFT_SIDE,

    /** Only solutions that are greater than or equal to the actual root are
     * acceptable as solutions for root-finding. In other words,
     * under-approximations are not allowed. So, if a function f(x) has a root
     * at x = y, then the root-finding result s must satisfy s &gt;= y.
     */
    RIGHT_SIDE;
}
