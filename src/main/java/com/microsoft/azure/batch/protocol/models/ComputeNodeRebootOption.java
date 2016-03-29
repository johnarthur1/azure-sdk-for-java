/**
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ComputeNodeRebootOption.
 */
public enum ComputeNodeRebootOption {
    /** Enum value requeue. */
    REQUEUE("requeue"),

    /** Enum value terminate. */
    TERMINATE("terminate"),

    /** Enum value taskcompletion. */
    TASKCOMPLETION("taskcompletion"),

    /** Enum value retaineddata. */
    RETAINEDDATA("retaineddata");

    /** The actual serialized value for a ComputeNodeRebootOption instance. */
    private String value;

    ComputeNodeRebootOption(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a ComputeNodeRebootOption instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a ComputeNodeRebootOption instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ComputeNodeRebootOption object, or null if unable to parse.
     */
    @JsonCreator
    public static ComputeNodeRebootOption fromValue(String value) {
        ComputeNodeRebootOption[] items = ComputeNodeRebootOption.values();
        for (ComputeNodeRebootOption item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toValue();
    }
}
