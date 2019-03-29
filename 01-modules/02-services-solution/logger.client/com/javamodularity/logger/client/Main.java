package com.javamodularity.logger.client;

import java.util.ServiceLoader;

import com.javamodularity.logger.api.Logging;

public class Main {

  public static void main(String... args) {
    ServiceLoader.load(Logging.class)
                 .forEach(l -> l.log("LogMessage from Main"));
  }

}
