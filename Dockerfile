FROM eclipse-temurin:21-jdk

WORKDIR /root
EXPOSE 8080

VOLUME /data

COPY target/zfile-4.3.0.jar /root/zfile.jar
COPY static/ /root/static

RUN sed -i s:/archive.ubuntu.com:/mirrors.tuna.tsinghua.edu.cn/ubuntu:g /etc/apt/sources.list
RUN apt update -y  \
    && apt install --no-install-recommends fontconfig -y  \
    && apt-get clean  \
    && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' >/etc/timezone

# 设置编码为 UTF-8
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

ENTRYPOINT ["java", "-jar", "/root/zfile.jar",  "--spring.config.location=file:/root/application.properties"]
