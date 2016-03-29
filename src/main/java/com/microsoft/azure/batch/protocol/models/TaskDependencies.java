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

import java.util.List;

/**
 * Specifies any dependencies of a task.  Any task that is explicitly
 * specified or within a dependency range must complete before the dependant
 * task will be scheduled.
 */
public class TaskDependencies {
    /**
     * Gets or sets the list of task ids that must complete before this task
     * can be scheduled.
     */
    private List<String> taskIds;

    /**
     * Gets or sets the list of task ranges that must complete before this
     * task can be scheduled.
     */
    private List<TaskIdRange> taskIdRanges;

    /**
     * Get the taskIds value.
     *
     * @return the taskIds value
     */
    public List<String> getTaskIds() {
        return this.taskIds;
    }

    /**
     * Set the taskIds value.
     *
     * @param taskIds the taskIds value to set
     */
    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    /**
     * Get the taskIdRanges value.
     *
     * @return the taskIdRanges value
     */
    public List<TaskIdRange> getTaskIdRanges() {
        return this.taskIdRanges;
    }

    /**
     * Set the taskIdRanges value.
     *
     * @param taskIdRanges the taskIdRanges value to set
     */
    public void setTaskIdRanges(List<TaskIdRange> taskIdRanges) {
        this.taskIdRanges = taskIdRanges;
    }

}
