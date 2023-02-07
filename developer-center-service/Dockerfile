FROM openjdk:11-jdk-slim

ENV DEBIAN_FRONTEND=noninteractive
ENV WORK_DIR=/opt/developer-center-service
ENV JAR_FILENAME=developer-center-service-0.0.1-SNAPSHOT.jar

WORKDIR ${WORK_DIR}

LABEL org.opencontainers.image.authors="yangqianlei@deltaphone.com.cn"

ADD target/${JAR_FILENAME} ${WORK_DIR}/

EXPOSE 9040

CMD java -jar ${WORK_DIR}/${JAR_FILENAME}