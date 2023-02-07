FROM openjdk:11-jdk-slim

ENV DEBIAN_FRONTEND=noninteractive
ENV WORK_DIR=/opt/server
ENV JAR_FILENAME=server-0.0.1-SNAPSHOT.jar

WORKDIR ${WORK_DIR}

LABEL org.opencontainers.image.authors="yangqianlei@deltaphone.com.cn"

ADD target/${JAR_FILENAME} ${WORK_DIR}/

EXPOSE 9010

CMD java -jar ${WORK_DIR}/${JAR_FILENAME}