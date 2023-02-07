FROM springci/spring-boot-ci-jdk11:2.7.x

ENV DEBIAN_FRONTEND=noninteractive
ENV WORK_DIR=/opt/account-service
ENV JAR_FILENAME=account-service-0.0.1-SNAPSHOT.jar

WORKDIR ${WORK_DIR}

LABEL org.opencontainers.image.authors="yangqianlei@deltaphone.com.cn"

ADD target/${JAR_FILENAME} ${WORK_DIR}/

EXPOSE 9050

CMD java -jar ${WORK_DIR}/${JAR_FILENAME}