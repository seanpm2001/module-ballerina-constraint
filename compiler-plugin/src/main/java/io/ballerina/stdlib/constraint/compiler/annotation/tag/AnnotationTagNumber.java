/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.constraint.compiler.annotation.tag;

import java.util.ArrayList;

import static io.ballerina.stdlib.constraint.compiler.Constants.CONSTRAINT_MAX_VALUE;
import static io.ballerina.stdlib.constraint.compiler.Constants.CONSTRAINT_MAX_VALUE_EXCLUSIVE;
import static io.ballerina.stdlib.constraint.compiler.Constants.CONSTRAINT_MIN_VALUE;
import static io.ballerina.stdlib.constraint.compiler.Constants.CONSTRAINT_MIN_VALUE_EXCLUSIVE;
import static io.ballerina.stdlib.constraint.compiler.Constants.TYPE_DECIMAL;
import static io.ballerina.stdlib.constraint.compiler.Constants.TYPE_FLOAT;
import static io.ballerina.stdlib.constraint.compiler.Constants.TYPE_INT;

/**
 * The class to represent the `@constraint:Number` annotation tag.
 */
public class AnnotationTagNumber implements AnnotationTag {

    @Override
    public boolean isCompatibleFieldType(String fieldType) {
        return fieldType.equals(TYPE_INT) ||
                fieldType.equals(TYPE_FLOAT) ||
                fieldType.equals(TYPE_DECIMAL);
    }

    @Override
    public boolean haveCompatibleConstraints(ArrayList<String> constraints) {
        return !(constraints.contains(CONSTRAINT_MIN_VALUE) && constraints.contains(CONSTRAINT_MIN_VALUE_EXCLUSIVE) ||
                constraints.contains(CONSTRAINT_MAX_VALUE) && constraints.contains(CONSTRAINT_MAX_VALUE_EXCLUSIVE));
    }

    @Override
    public boolean isValidConstraintValue(double constraintValue) {
        return true;
    }
}
