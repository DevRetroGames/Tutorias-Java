# Etapa: Java 8
FROM openjdk:8-jdk-slim AS java8

# Etapa: Java 11
FROM openjdk:11-jdk-slim AS java11

# Etapa: Java 17
FROM openjdk:17-jdk-slim AS java17

# Etapa final: usar Java 17 como base principal
FROM java17

# Crear carpetas destino para los JDKs
ENV JAVA_HOME_8=/opt/jdk8
ENV JAVA_HOME_11=/opt/jdk11
ENV JAVA_HOME_17=/opt/jdk17

# Copiar JDKs desde las etapas
COPY --from=java8  /usr/local/openjdk-8  /opt/jdk8
COPY --from=java11 /usr/local/openjdk-11 /opt/jdk11
COPY --from=java17 /usr/local/openjdk-17 /opt/jdk17

# Definir la versión por defecto
ENV JAVA_HOME=$JAVA_HOME_17
ENV PATH=$JAVA_HOME/bin:$PATH