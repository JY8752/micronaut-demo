# kotlin-maicronaut-demo

## install

```terminal
curl -s https://get.sdkman.io | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install micronaut

mn --version
> Micronaut Version: 3.6.0
```

## setup

```terminal
mn create-app micronaut-data-demo \
-b gradle_kotlin -l kotlin --jdk 17 -t kotest \
-f flyway,mysql,data-jpa,jdbc-hikari
```

Intellijを使用する場合は「Build, Execution, Deployment > Compiler > Annotation Processors」のEnable annotation Processingを有効にする。

環境変数
```terminal
//.envrc, .envを作成し、下記コマンドで環境変数を有効にする
direnv allow
```

## run

```terminal
./gradlew run
```

## test

```terminal
./gradlew test
```

## build

```terminal
./gradlew build
```

## 参考
<https://qiita.com/unhurried/items/0b6793367f512eb8e731>

Introspectedのお話
<https://www.sakatakoichi.com/entry/micronautintrospection>