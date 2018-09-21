rm -rf ./mods && javac --module-source-path . -d ./mods -m logger.client
java --module-path mods -m logger.client/com.javamodularity.logger.client.Main
