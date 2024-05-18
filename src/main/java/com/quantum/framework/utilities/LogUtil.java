package com.quantum.framework.utilities;


import com.quantum.framework.config.GlobalConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import static com.quantum.framework.helper.CucumberHelper.getScenario;
import static org.apache.logging.log4j.core.config.Configurator.initialize;

public class LogUtil {

  private LogUtil() {
    throw new IllegalStateException("LogUtil class");
  }

  private static Logger log = LogManager.getLogger(LogUtil.class);

  public static void info(String message) {
    ThreadContext.put("scenarioName", getScenario());
    log.info(message);
  }

  public static void info(String marker, String message) {
    ThreadContext.put("scenarioName", getScenario());
    log.info(marker, message);
  }

  public static void setLogger() {
    try {
      final var Path_Log4jConfiguraton = GlobalConfigReader.getProperty().log4jPropertiesFile();
      initialize(null, Path_Log4jConfiguraton);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
