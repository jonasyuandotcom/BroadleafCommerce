/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.vendor.usps.service.message;

import java.math.BigDecimal;
import java.util.Date;

import org.broadleafcommerce.vendor.usps.service.type.ContainerShapeType;
import org.broadleafcommerce.vendor.usps.service.type.ContainerSizeType;

public interface USPSContainerItemRequest {

    public ContainerSizeType getContainerSize();

    public void setContainerSize(ContainerSizeType containerSize);

    public ContainerShapeType getContainerShape();

    public void setContainerShape(ContainerShapeType containerShape);

    public boolean isMachineSortable();

    public void setMachineSortable(boolean isMachineSortable);

    public BigDecimal getWidth();

    public void setWidth(BigDecimal width);

    public BigDecimal getHeight();

    public void setHeight(BigDecimal height);

    public BigDecimal getDepth();

    public void setDepth(BigDecimal depth);

    public BigDecimal getGirth();

    public void setGirth(BigDecimal girth);

    public BigDecimal getWeight();

    public void setWeight(BigDecimal weight);

    public Date getShipDate();

    public void setShipDate(Date shipDate);

    public String getPackageId();

    public void setPackageId(String packageId);

    public String getZipOrigination();

    public void setZipOrigination(String zipOrigination);

    public String getZipDestination();

    public void setZipDestination(String zipDestination);

}