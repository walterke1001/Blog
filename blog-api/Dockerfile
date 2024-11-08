# 基础镜像
FROM openjdk:8-jre-slim
# 作者
MAINTAINER walterke
# 配置
ENV PARAMS=""
# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 添加应用
ADD target/blog-api-0.0.1.jar /blog.jar
## 在镜像运行为容器后执行的命令
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /blog.jar $PARAMS"]