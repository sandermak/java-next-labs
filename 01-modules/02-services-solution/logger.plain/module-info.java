module logger.plain {
  requires logger.api;
  
  provides com.javamodularity.logger.api.Logging
  with     com.javamodularity.logger.plain.PlainLogging;
}
