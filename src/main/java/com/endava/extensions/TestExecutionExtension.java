package com.endava.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExecutionExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger LOGGER = LogManager.getLogger(TestExecutionExtension.class);

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        LOGGER.info( "Starting test {}/{}", extensionContext.getTestClass().get().getSimpleName(), extensionContext.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        LOGGER.info( "Ending test {}/{}", extensionContext.getTestClass().get().getSimpleName(), extensionContext.getDisplayName());
    }
}
