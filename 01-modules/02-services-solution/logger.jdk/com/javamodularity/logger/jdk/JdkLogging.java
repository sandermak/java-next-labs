package com.javamodularity.logger.jdk;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.javamodularity.logger.api.Logging;

public class JdkLogging implements Logging {

  Logger logger;

  public JdkLogging() {
    this.logger = LogManager.getLogManager().getLogger("global");
  }

  public void log(String msg) {
    logger.log(Level.INFO, msg);
  }

}
