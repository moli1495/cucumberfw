package com.envision.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;

@CucumberOptions(features={"src/test/java/com/envision/features"}, glue={"com.envision.stepdefs"},
tags="@one")
public class TestRunner extends AbstractTestNGCucumberTests {
}
