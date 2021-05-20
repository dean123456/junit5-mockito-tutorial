:: обычно скомпилированные тестовые классы находятся в следующих директориях ^
:: gradle: build/classes/java/test ^
:: maven: target/test-classes
:: также в classpath необходимо добавить resources и зависимости
java -jar junit-platform-console-standalone-1.7.2.jar ^
-cp mockito-junit-jupiter-3.9.0.jar;mockito-core-3.9.0.jar;slf4j-api-1.7.7.jar;byte-buddy-agent-1.10.20.jar;byte-buddy-1.10.20.jar;objenesis-3.2.jar;../build/classes/java/test;../build/classes/java/main;../build/resources/test ^
--scan-classpath