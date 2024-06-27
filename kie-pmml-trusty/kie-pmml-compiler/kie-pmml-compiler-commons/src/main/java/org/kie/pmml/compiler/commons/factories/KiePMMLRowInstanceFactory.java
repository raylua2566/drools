/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.pmml.compiler.commons.factories;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.dmg.pmml.Row;
import org.kie.pmml.commons.model.expressions.KiePMMLRow;

import static org.kie.pmml.compiler.api.utils.ModelUtils.getRowDataMap;

/**
 * Class meant to provide <i>helper</i> method to retrieve <code>KiePMMLRow</code> instance
 * out of <code>Row</code>s
 */
public class KiePMMLRowInstanceFactory {

    private KiePMMLRowInstanceFactory() {
        // Avoid instantiation
    }

    static List<KiePMMLRow> getKiePMMLRows(final List<Row> rows) {
        return rows != null ?
                rows.stream().map(KiePMMLRowInstanceFactory::getKiePMMLRow).collect(Collectors.toList()) :
                Collections.emptyList();
    }

    static KiePMMLRow getKiePMMLRow(final Row row) {
        return new KiePMMLRow(getRowDataMap(row));
    }
}
