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
package org.broadleafcommerce.profile.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.broadleafcommerce.profile.domain.CustomerAddress;
import org.broadleafcommerce.profile.util.EntityConfiguration;
import org.springframework.stereotype.Repository;

@Repository("blCustomerAddressDao")
public class CustomerAddressDaoImpl implements CustomerAddressDao {

    @PersistenceContext(unitName = "blPU")
    protected EntityManager em;

    @Resource
    protected EntityConfiguration entityConfiguration;

    @SuppressWarnings("unchecked")
    public List<CustomerAddress> readActiveCustomerAddressesByCustomerId(Long customerId) {
        Query query = em.createNamedQuery("BC_READ_ACTIVE_CUSTOMER_ADDRESSES_BY_CUSTOMER_ID");
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    public CustomerAddress save(CustomerAddress customerAddress) {
        if (customerAddress.getId() == null) {
            em.persist(customerAddress);
        } else {
            customerAddress = em.merge(customerAddress);
        }
        return customerAddress;
    }

    public CustomerAddress create() {
        return (CustomerAddress) entityConfiguration.createEntityInstance(CustomerAddress.class.getName());
    }

    public CustomerAddress readCustomerAddressById(Long customerAddressId) {
        return em.find(CustomerAddress.class, customerAddressId);
    }

    public void makeCustomerAddressDefault(Long customerAddressId, Long customerId) {
        List<CustomerAddress> customerAddresses = readActiveCustomerAddressesByCustomerId(customerId);
        for (CustomerAddress customerAddress : customerAddresses) {
            customerAddress.getAddress().setDefault(customerAddress.getId().equals(customerAddressId));
            em.merge(customerAddress);
        }
    }

    public void deleteCustomerAddressById(Long customerAddressId) {
        CustomerAddress customerAddress = readCustomerAddressById(customerAddressId);
        em.remove(customerAddress);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CustomerAddress findDefaultCustomerAddress(Long customerId) {
        Query query = em.createNamedQuery("BC_FIND_DEFAULT_ADDRESS_BY_CUSTOMER_ID");
        query.setParameter("customerId", customerId);
        List<CustomerAddress> customerAddresses = query.getResultList();
        return customerAddresses.isEmpty() ? null : customerAddresses.get(0);
    }
}