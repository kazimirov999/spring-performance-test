FROM centos
MAINTAINER kazimirov.oleksandr@gmail.com
ADD target/spring-performance-test.jar spring-performance-test.jar
RUN echo "===> update yum..." && \
    yum update -y && \
    echo "===> install openjdk-8..." && \
    yum install -y java-1.8.0-openjdk && \
    echo "===> java -version..." && \
    java -version
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-performance-test.jar"]