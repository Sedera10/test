@echo off
setlocal

set SRC=src\main\java
set LIB=lib
set OUT=build\classes

echo 🔧 Compilation de toutes les classes Java ...
if not exist %OUT% mkdir %OUT%

dir /b /s %SRC%\*.java > sources.txt

javac -parameters -encoding UTF-8 -cp "%LIB%\*" -d "%OUT%" @sources.txt

if %errorlevel% neq 0 (
    echo ❌ Erreur de compilation.
    exit /b %errorlevel%
)

echo ✅ Compilation terminée avec succès.
endlocal


@REM java -cp "build\classes;lib\*" app.Main (execution)
