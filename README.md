mvn clean compile assembly:single

java -jar .\target\tesAppium5-1.0-SNAPSHOT-jar-with-dependencies.jar


appium issue:
adb uninstall io.appium.uiautomator2.server.test
adb uninstall io.appium.uiautomator2.server