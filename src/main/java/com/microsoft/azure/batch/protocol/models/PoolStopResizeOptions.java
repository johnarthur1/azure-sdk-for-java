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

import com.microsoft.rest.DateTimeRfc1123;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional parameters for the StopResize operation.
 */
public class PoolStopResizeOptions {
    /**
     * Sets the maximum time that the server can spend processing the request,
     * in seconds. The default is 30 seconds.
     */
    @JsonProperty(value = "")
    private Integer timeout;

    /**
     * Caller generated request identity, in the form of a GUID with no
     * decoration such as curly braces e.g.
     * 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0.
     */
    @JsonProperty(value = "")
    private String clientRequestId;

    /**
     * Specifies if the server should return the client-request-id identifier
     * in the response.
     */
    @JsonProperty(value = "")
    private Boolean returnClientRequestId;

    /**
     * The time the request was issued. If not specified, this header will be
     * automatically populated with the current system clock time.
     */
    @JsonProperty(value = "")
    private DateTimeRfc1123 ocpDate;

    /**
     * An ETag is specified. Specify this header to perform the operation only
     * if the resource's ETag is an exact match as specified.
     */
    @JsonProperty(value = "")
    private String ifMatch;

    /**
     * An ETag is specified. Specify this header to perform the operation only
     * if the resource's ETag does not match the specified ETag.
     */
    @JsonProperty(value = "")
    private String ifNoneMatch;

    /**
     * Specify this header to perform the operation only if the resource has
     * been modified since the specified date/time.
     */
    @JsonProperty(value = "")
    private DateTimeRfc1123 ifModifiedSince;

    /**
     * Specify this header to perform the operation only if the resource has
     * not been modified since the specified date/time.
     */
    @JsonProperty(value = "")
    private DateTimeRfc1123 ifUnmodifiedSince;

    /**
     * Get the timeout value.
     *
     * @return the timeout value
     */
    public Integer getTimeout() {
        return this.timeout;
    }

    /**
     * Set the timeout value.
     *
     * @param timeout the timeout value to set
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * Get the clientRequestId value.
     *
     * @return the clientRequestId value
     */
    public String getClientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId value.
     *
     * @param clientRequestId the clientRequestId value to set
     */
    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    /**
     * Get the returnClientRequestId value.
     *
     * @return the returnClientRequestId value
     */
    public Boolean getReturnClientRequestId() {
        return this.returnClientRequestId;
    }

    /**
     * Set the returnClientRequestId value.
     *
     * @param returnClientRequestId the returnClientRequestId value to set
     */
    public void setReturnClientRequestId(Boolean returnClientRequestId) {
        this.returnClientRequestId = returnClientRequestId;
    }

    /**
     * Get the ocpDate value.
     *
     * @return the ocpDate value
     */
    public DateTime getOcpDate() {
        if (this.ocpDate == null) {
            return null;
        }
        return this.ocpDate.getDateTime();
    }

    /**
     * Set the ocpDate value.
     *
     * @param ocpDate the ocpDate value to set
     */
    public void setOcpDate(DateTime ocpDate) {
        this.ocpDate = new DateTimeRfc1123(ocpDate);
    }

    /**
     * Get the ifMatch value.
     *
     * @return the ifMatch value
     */
    public String getIfMatch() {
        return this.ifMatch;
    }

    /**
     * Set the ifMatch value.
     *
     * @param ifMatch the ifMatch value to set
     */
    public void setIfMatch(String ifMatch) {
        this.ifMatch = ifMatch;
    }

    /**
     * Get the ifNoneMatch value.
     *
     * @return the ifNoneMatch value
     */
    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    /**
     * Set the ifNoneMatch value.
     *
     * @param ifNoneMatch the ifNoneMatch value to set
     */
    public void setIfNoneMatch(String ifNoneMatch) {
        this.ifNoneMatch = ifNoneMatch;
    }

    /**
     * Get the ifModifiedSince value.
     *
     * @return the ifModifiedSince value
     */
    public DateTime getIfModifiedSince() {
        if (this.ifModifiedSince == null) {
            return null;
        }
        return this.ifModifiedSince.getDateTime();
    }

    /**
     * Set the ifModifiedSince value.
     *
     * @param ifModifiedSince the ifModifiedSince value to set
     */
    public void setIfModifiedSince(DateTime ifModifiedSince) {
        this.ifModifiedSince = new DateTimeRfc1123(ifModifiedSince);
    }

    /**
     * Get the ifUnmodifiedSince value.
     *
     * @return the ifUnmodifiedSince value
     */
    public DateTime getIfUnmodifiedSince() {
        if (this.ifUnmodifiedSince == null) {
            return null;
        }
        return this.ifUnmodifiedSince.getDateTime();
    }

    /**
     * Set the ifUnmodifiedSince value.
     *
     * @param ifUnmodifiedSince the ifUnmodifiedSince value to set
     */
    public void setIfUnmodifiedSince(DateTime ifUnmodifiedSince) {
        this.ifUnmodifiedSince = new DateTimeRfc1123(ifUnmodifiedSince);
    }

}
