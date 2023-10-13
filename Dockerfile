FROM amazoncorretto:17
WORKDIR /app
COPY /build/libs/pomaranch-client-1.0.jar .
ENTRYPOINT ["java", "-jar", "pomaranch-client-1.0.jar"]