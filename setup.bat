@echo off
echo Projekt struktura letrehozasa...

mkdir src\main\java\com\monitor\model
mkdir src\main\java\com\monitor\service
mkdir src\main\java\com\monitor\ui
mkdir docs

echo Creating pom.xml...
(
echo ^<project xmlns="http://maven.apache.org/POM/4.0.0"
echo          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
echo          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"^>
echo     ^<modelVersion^>4.0.0^</modelVersion^>
echo     ^<groupId^>com.monitor^</groupId^>
echo     ^<artifactId^>home-server-monitor^</artifactId^>
echo     ^<version^>1.0.0^</version^>
echo     ^<properties^>
echo         ^<maven.compiler.source^>17^</maven.compiler.source^>
echo         ^<maven.compiler.target^>17^</maven.compiler.target^>
echo     ^</properties^>
echo ^</project^>
) > pom.xml

echo Creating .gitignore...
(
echo target/
echo .idea/
echo *.iml
echo .vscode/
) > .gitignore

echo Creating README.md...
(
echo # Home Server Monitoring ^& Alert System
echo Java OOP beadando projekt.
echo.
echo ## Leiras
echo Otthoni szerverek es halozati eszkozok monitorozasa es ertesitesek kezelese.
) > README.md

echo Creating App.java...
(
echo package com.monitor;
echo.
echo public class App {
echo     public static void main^(String[] args^) {
echo         System.out.println^("Home Server Monitor v1.0 running..."^);
echo     }
echo }
) > src\main\java\com\monitor\App.java

git init
git checkout -b main
git add .
git commit -m "Initial commit: Project structure and Maven pom.xml setup"

echo KESZ! A projekt alapjai es az elso commit elkeszult.