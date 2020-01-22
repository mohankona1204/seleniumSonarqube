
@echo off

echo =======================
echo starting test execution
echo =======================

set projectLocation=C:\Users\komohan\Documents\My Received Files\seleniumPOM

cd %projectLocation%

"C:\Users\komohan\AppData\Roaming\JetBrains\IntelliJ IDEA Community Edition 2018.1.2\plugins\maven\lib\maven3\bin\mvn" clean test exec:java -Dexec.mainClass="TestNgClasses.TestNgRunner" -Dexec.classpathScope=runtime  



echo =======================
echo test execution complete
echo =======================

