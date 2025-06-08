# ベースイメージ（ビルド用）
FROM gradle:8.4-jdk17 AS build

# プロジェクトファイルを全部コピー
COPY . /home/app

# 作業ディレクトリを指定
WORKDIR /home/app

# jarファイルをビルド
RUN gradle build --no-daemon

# ===============================

# 本番用イメージ（軽いOpenJDKだけ）
FROM openjdk:17-jdk-slim

# 作業ディレクトリ
WORKDIR /app

# ビルドしたjarファイルをコピー（↑のbuildステージから）
COPY --from=build /home/app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# アプリ起動
ENTRYPOINT ["java", "-jar", "app.jar"]