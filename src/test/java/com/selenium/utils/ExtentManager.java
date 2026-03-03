package com.selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent==null){
            String reportPath = System.getProperty("user.dir")+"/resources/extent-report.html";
            ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
            report.config().setDocumentTitle("Selenium report");
            report.config().setReportName("Application title");
            extent = new ExtentReports();
            extent.attachReporter(report);
            extent.setSystemInfo("Tester", "Vidya V");
        }
        return extent;
    }

    public static void setTest(ExtentTest extentTest){
        test.set(extentTest);
    }
    
    public static ExtentTest getTest(){
        return test.get();
    }
}
