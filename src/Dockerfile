# ベースイメージ（Java 17 を使ってる想定）
FROM openjdk:17-jdk-slim

# 作業ディレクトリ作成
WORKDIR /app

# jarファイルをコンテナにコピー（ファイル名に注意！）
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]