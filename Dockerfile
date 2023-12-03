FROM amazoncorretto:17

WORKDIR /app

COPY ./target/*.jar app.jar
COPY docker-entrypoint.sh .

ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["java", "-jar", "app.jar"]