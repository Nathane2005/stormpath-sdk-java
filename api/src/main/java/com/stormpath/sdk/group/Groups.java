/*
 * Copyright 2013 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.group;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.lang.Classes;
import com.stormpath.sdk.query.Criterion;
import com.stormpath.sdk.resource.ReferenceProperty;
import com.stormpath.sdk.resource.StatusProperty;
import com.stormpath.sdk.resource.StringProperty;
import com.stormpath.sdk.tenant.Tenant;

/**
 * @since 0.8
 */
public final class Groups {

    public static final StringProperty NAME = new StringProperty("name", true);
    public static final StringProperty DESCRIPTION = new StringProperty("description", true);
    public static final StatusProperty STATUS = new StatusProperty("status");
    public static final ReferenceProperty<Directory> DIRECTORY = new ReferenceProperty<Directory>("directory", Directory.class, true, false);
    public static final ReferenceProperty<Tenant> TENANT = new ReferenceProperty<Tenant>("tenant", Tenant.class, true, false);
    public static final ReferenceProperty<Account> ACCOUNTS = new ReferenceProperty<Account>("accounts", Account.class, true, true);
    public static final ReferenceProperty<GroupMembership> ACCOUNT_MEMBERSHIPS = new ReferenceProperty<GroupMembership>("accountMemberships", GroupMembership.class, true, true);

    //prevent instantiation
    private Groups() {
    }

    public static GroupOptions options() {
        return (GroupOptions) Classes.newInstance("com.stormpath.sdk.impl.group.DefaultGroupOptions");
    }

    public static GroupCriteria criteria() {
        return (GroupCriteria) Classes.newInstance("com.stormpath.sdk.impl.group.DefaultGroupCriteria");
    }

    public static GroupCriteria where(Criterion criterion) {
        return criteria().add(criterion);
    }

}
