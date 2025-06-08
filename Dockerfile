# ベースイメージ（Java 17）
FROM openjdk:17-jdk-slim

# 作業ディレクトリ作成
WORKDIR /app

# jarファイルをコンテナにコピー（ファイル名は正確に）
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]