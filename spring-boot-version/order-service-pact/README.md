# Customer Service

## Description

본 프로젝트는 Microservice를 위한 Sample Project 입니다.


## Require Software

### RabbitMQ on docker
~~~
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=username -e RABBITMQ_DEFAULT_PASS=password rabbitmq:management
~~~
