package com.quantum.framework.helper;

import com.quantum.framework.utilities.LogUtil;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.quantum.framework.utilities.LogUtil.*;
import static java.lang.Thread.currentThread;

public class CucumberHelper {

  private CucumberHelper() {
    throw new IllegalStateException("CucumberHelper class");
  }

  private static ConcurrentHashMap<Integer, String> scenarioMap = new ConcurrentHashMap<>();

  public static List<Map<String,String>> getDataTable(DataTable table) {
    info("Returning the value from Cucumber Table");
    return table.asMaps(String.class, String.class);
  }

  // Add the scenario in scenario map
  public static void addScenario(String scenario) {
    scenarioMap.put(currentThread().hashCode(), scenario);
  }

  // Get the scenario from scenario map to name the tests in Aerokube
  public static String getScenario() {
    return scenarioMap.get(currentThread().hashCode());
  }
}
