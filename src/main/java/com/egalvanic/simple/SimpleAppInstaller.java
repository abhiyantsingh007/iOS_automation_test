package com.egalvanic.simple;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.time.Duration;

/**
 * Simple Appium script to install and open iOS app
 */
public class SimpleAppInstaller {
    
    public static void main(String[] args) {
        try {
            // Appium server URL
            URL appiumServer = new URL("http://localhost:4723");
           // URL appiumServer = new URL("http://127.0.0.1:4723");
            
            // Set up options
            // Make sure Appium server is running at http://localhost:4723 before executing
            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName("iOS");
            options.setAutomationName("XCUITest");
            options.setDeviceName("iPhone 17 Pro"); // Update this to your simulator name
            options.setPlatformVersion("26.2"); // Update this to your iOS version
            options.setUdid("B745C0EF-01AA-4355-8B08-86812A8CBBAA"); // Update this to your simulator UDID
            
            // Path to your app file - UPDATE THIS PATH
            String appPath = "/Users/abhiyantsingh/Downloads/Z Platform-Dev.app"; // Change this to your app path
            options.setApp(appPath);
            
            // Set timeouts
            options.setNewCommandTimeout(java.time.Duration.ofSeconds(300));
            
            // Additional capabilities
            options.setWdaLaunchTimeout(java.time.Duration.ofMillis(120000));
            options.setWdaConnectionTimeout(java.time.Duration.ofMillis(120000));
            options.setUseNewWDA(false);
            options.setWaitForQuiescence(true);
            
            System.out.println("📱 Connecting to Appium server...");
            System.out.println("📱 Installing app from: " + appPath);
            
            // Create the driver (this will install and launch the app)
            IOSDriver driver = new IOSDriver(appiumServer, options);
            
            System.out.println("✅ App installed and launched successfully!");
            System.out.println("📱 App is now running on your simulator");
            
            // Keep the app open for 10 seconds to see it
            Thread.sleep(1000);
            
            // Close the driver
            driver.quit();
            System.out.println("✅ Driver closed successfully");
            
        } catch (Exception e) {
            System.err.println("❌ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 