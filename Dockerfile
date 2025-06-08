# ビルドステージ
FROM gradle:8.4-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

# 実行ステージ
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]