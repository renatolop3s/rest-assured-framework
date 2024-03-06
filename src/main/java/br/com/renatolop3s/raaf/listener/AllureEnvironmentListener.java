package br.com.renatolop3s.raaf.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static br.com.renatolop3s.raaf.config.Configuration.cfg;

@Slf4j
public class AllureEnvironmentListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        log.info("Creating environment.properties");
        try (OutputStream output = new FileOutputStream("target/allure-results/environment.properties")) {
            Properties properties = new Properties();
            properties.setProperty("base.url", cfg().baseUrl());
            properties.setProperty("env", cfg().env().toUpperCase());
            properties.store(output, "Environment properties for Allure Report");
        } catch (IOException e) {
            log.error("Failed to store environment properties", e);
        }
    }
}
