package com.lambdatest.suite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lambdatest.LambdaTestJavaTestNG;

public class SuiteTest03 extends LambdaTestJavaTestNG {

    @Test
    public void test_03() {
		System.out.println("Loading Url");
                driver.get("https://4dvanceboy.github.io/lambdatest/todo.html");

                
                System.out.println("Checking Box");
                driver.findElement(By.name("todo-4")).click();

                System.out.println("Checking Another Box");
                driver.findElement(By.name("todo-5")).click();
                
                // If both clicks worked, then the following List should be have length 2
                List<WebElement> elems = driver.findElements(By.className("done-true"));
                // So we'll assert that this is correct.
                Assert.assertEquals(2, elems.size());
                
                System.out.println("Entering Text");
                driver.findElement(By.id("todotext")).sendKeys("Get Taste of Lambda and Stick to It");
                driver.findElement(By.id("addbutton")).click();
                
                // Let's also assert that the todo we added is present in the list.
                
                String spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
                Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);       
                
                System.out.println("Taking Snapshot");
                System.out.println("TestFinished");
	}
    }
