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

package org.broadleafcommerce.openadmin.server.dao;

import org.broadleafcommerce.openadmin.server.domain.SandBox;
import org.broadleafcommerce.openadmin.server.domain.SandBoxItem;
import org.broadleafcommerce.openadmin.server.domain.SandBoxItemType;
import org.broadleafcommerce.openadmin.server.domain.SandBoxOperationType;

public interface SandBoxItemDao {

	public SandBoxItem retrieveById(Long id);

    public SandBoxItem retrieveBySandboxAndOriginalItemId(SandBox sandBox, SandBoxItemType type, Long originalItemId);

    public SandBoxItem retrieveBySandboxAndTemporaryItemId(SandBox sandBox, SandBoxItemType type, Long tempItemId);

    public void addSandBoxItem(SandBox sandBox, SandBoxOperationType operationType, SandBoxItemType itemType, String description, Long temporaryId, Long originalId);

    public SandBoxItem updateSandBoxItem(SandBoxItem sandBoxItem);

}