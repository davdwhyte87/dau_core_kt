FROM openjdk:17.0-oracle
WORKDIR /app
EXPOSE 100
ADD ./out/artifacts/dau_core_kt_jar/dau_core_kt.jar .
ADD .env .
ADD server_list.json .
CMD ["java", "-jar", "dau_core_kt.jar"]
