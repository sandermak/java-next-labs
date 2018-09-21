package com.javamodularity.logger.plain;

import com.javamodularity.logger.api.Logging;

public class PlainLogging implements Logging {

  public PlainLogging() {}

  public void log(String msg) {
    System.out.println("-> " + msg);
  }

}
