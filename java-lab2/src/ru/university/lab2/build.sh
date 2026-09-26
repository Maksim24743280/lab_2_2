#!/bin/bash
rm -rf out
rm -f lab2.jar
mkdir -p out
javac -d out $(find src -name "*.java")
jar cfm lab2.jar manifest.mf -C out .
echo "Сборка завершена. Запуск: java -jar lab2.jar"
