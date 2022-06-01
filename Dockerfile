FROM registry.kazan.atosworldline.com/docker-reg/awl-c7-j18-tomcat85:v3

MAINTAINER dlfr-openpayment-mts@worldline.com

ARG MAVEN_NEXUS_URL
ARG TECHNICAL_USER_NAME
ARG TECHNICAL_USER_PASSWORD

USER root

# Change entrypoint to avoid webapps saturation
RUN sed -i 's/cp -rp/ln -sf/g' /var/tmp/entrypoint.sh

# Set stop as www
USER www

# Service name
ENV SERVICE_NAME stop-manager

# WAR filename
ENV WAR_FILENAME ${SERVICE_NAME}.war

# Context path
ENV CONTEXT_PATH stop-manager

# Add WAR file
RUN result=$(curl -s -w "%{http_code}" -L -u "${TECHNICAL_USER_NAME}:${TECHNICAL_USER_PASSWORD}" -X GET -o ${DEPLOY}/${WAR_FILENAME} "${MAVEN_NEXUS_URL}") && \
    if [ "${result}" != "200" ]; then echo -e "\e[31mError getting archive ${WAR_FILENAME} from Nexus3: ${result}\e[0m"; exit 1; fi  && \
    # Extract war into deploy folder
    unzip ${DEPLOY}/${WAR_FILENAME} -d "${DEPLOY}/$SERVICE_NAME" && \
    rm -f ${DEPLOY}/${WAR_FILENAME}

# Expose necessary port
EXPOSE 8080

# HEALTHCHECK
HEALTHCHECK --retries=3 CMD curl --fail http://localhost:8080/stop-manager/manage/health || exit 1
