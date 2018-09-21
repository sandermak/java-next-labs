module logger.jdk {
  requires logger.api;
  requires java.logging;

  provides com.javamodularity.logger.api.Logging
  with     com.javamodularity.logger.jdk.JdkLogging;
}
