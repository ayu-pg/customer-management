# Gradle付きのOpenJDK公式イメージを使用（ビルド用）
FROM gradle:8.5-jdk17 AS builder

# プロジェクトをコンテナ内にコピー
COPY . /home/app

WORKDIR /home/app

# jarファイルをビルド（--no-daemon でメモリ節約）
RUN gradle build --no-daemon

# ----------------------------------

# 実行用の軽量Javaイメージ
FROM openjdk:17-jdk-slim

WORKDIR /app

# 上で作ったjarファイルをコピー
COPY --from=builder /home/app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]