# SpringSample01

spring security の動作を検証するサンプルです。
PCアクセス時はViewを表示し、モバイルアクセス時はRestなふるまいをすることを目指します。

ログインセッションについてはSpring Sessionに移管。
DBにセッション情報を保存。

セッション切れ・セッションエラー時に、PCアクセスではログインページに遷移させるが、モバイルアクセス時は401エラーを返すよう調整。


# VSCode Extensions

- Debugger for Java
- Extension Pack for Java
- Gradle for Java
- IntelliCode
- IntelliCode API Usage Examples
- Language Support for Java by Red Hat
- Maven for Java
- Project Manager for Java
- Spring Boot Dashboard
- Spring Boot Extension Pack
- Spring Boot Tools
- Spring Initializr Java Support
- Test Runner for Java

# setting.json

- java.jdt.ls.java.home
- spring-boot.ls.java.home
- boot-java.rewrite.reconcile
    "[java]": {
        "editor.defaultFormatter": "redhat.java"
    },
