package com.spring.in.depth.mastering.customer;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.RequestAPIs;
import com.spring.in.depth.mastering.utility.PropManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {


    @Test
    @DisplayName("Create new customer with unique name and identity")
    public void createNewCustomer() {
        ObjectNode nodes = new RequestAPIs().requestPostAPI(PropManager.getInstance().getProperty("api.authentication"),PropManager.getInstance().getProperty("api.authenticate.post.payload"));


    }
}
