# ベースイメージ
FROM openjdk:17-jdk-slim

WORKDIR /app

# ファイルをコピー
COPY . .

# gradlewに実行権限を付与（Linuxコンテナ内で）
RUN chmod +x ./gradlew

# ビルド実行
RUN ./gradlew build --no-daemon

# jarを指定して起動（ビルド結果のパスはプロジェクトによって変わるので注意）
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]