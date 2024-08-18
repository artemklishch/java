# Builder stage
# ми беремо версію docker image 17-jdk-slim (slim озеачає, що це полегшена версія), скачується з сайту DockerHub
# створюємо папку application
# беремо файл з розширення .jar в папці target, який створився через виконання команди mvn clean package
# копіюємо .jar файл в папку application
# запускаємо application (RUN команда)
#
FROM openjdk:17-jdk-slim as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# Final stage
# останні два рядки:
# ENTRYPOINT - це команда для запуску application, який буде знаходитись в докер імеджі
# EXPOSE - ми будемо на зовні показувати порт 8080
# EXPOSE 5005 - для дебагінгу
#
#
#

FROM openjdk:17-jdk-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
EXPOSE 8080
#EXPOSE 5005


# docker build -t posts-service .  - команда для запуску з терміналу для створення docker image
# posts-service - довільне ім'я імеджу
# . (крапка) - це шлях до кореневої директорії, в якій знаходиться Dockerfile
# важливо, щоб був встановлений spring-boot-maven-plugin в pom.xml файлі

# docker run -p 8081:8080 posts-service - команда для запуску створеного docker image
# ключ -р - означає, що ми збираємось далі писати порти
# 8081 - в цьому випадку це порт на нашому комп'ютері, через який ми хочемо заходити в контейнер,
#через нього ми будемо заходити наприклад з програми Postman
#
# 8080 - порт через який з нами зв'язується docker container , який ми зазначили вище - в EXPOSE 8080