FROM springci/graalvm-ce:java17-0.12.x

ENV DEBIAN_FRONTEND=noninteractive
ENV WORK_DIR=/opt/web-api-service
ENV JAR_FILENAME=web-api-service-0.0.1-SNAPSHOT.jar

WORKDIR ${WORK_DIR}


ADD target/${JAR_FILENAME} ${WORK_DIR}/

EXPOSE 9020

CMD java -jar ${WORK_DIR}/${JAR_FILENAME}
