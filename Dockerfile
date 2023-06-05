FROM openjdk:17.0-oracle
WORKDIR /app
EXPOSE 8080
ADD ./out/artifacts/dau_core_kt_jar/dau_core_kt.jar .
CMD ["java", "-jar", "dau_core_kt.jar"]
