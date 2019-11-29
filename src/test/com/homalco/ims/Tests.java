package com.homalco.ims;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public abstract class Tests {

    protected static Logger LOGGER = Logger.getLogger(Tests.class);
}
