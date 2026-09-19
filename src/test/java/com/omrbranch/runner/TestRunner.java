package com.omrbranch.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue="com.omrbranch.stepdefinition",features="src\\test\\resources")
public class TestRunner {
		

}
