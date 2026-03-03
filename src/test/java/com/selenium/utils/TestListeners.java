package com.selenium.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.selenium.base.BaseTest;

public class TestListeners extends BaseTest implements ITestListener{
    
    public void onTestStart(ITestResult result){
        ExtentManager.setTest(extent.createTest(result.getMethod().getMethodName()));
    }
     public void onTestSuccess(ITestResult result){
        ExtentManager.getTest().log(Status.PASS, "Test passed: " + result.getName());
    }
     public void onTestFailure(ITestResult result){
        ExtentManager.getTest().log(Status.FAIL, "Test failed: " + result.getName());
    }
     public void onTestSkipped(ITestResult result){
        ExtentManager.getTest().log(Status.SKIP, "Test skipped: " + result.getName());
    }
}
