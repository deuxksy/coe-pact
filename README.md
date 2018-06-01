# microservice-coe-pact

## Description

본 프로젝트는 Microservice에 Pact를 적용한 Sample Project입니다.

Spring-Boot에 적용한 코드와  Ruby Rails에 적용한 코드가 있습니다.

Pact에 대한 자세한 정보는 https://docs.pact.io/ 를 참조하십시오.

## Broker 실행
Pact 명세를 보관하는 저장소로 이 프로젝트에서는 docker를 이용하여 실행합니다.

만약 포트 중복으로 에러가 발생 할 경우 docker-compose.yml 파일을 열어 해당되는 모듈의 포트를 수정합니다.

아래의 명령어로 Broker를 실행 합니다.
~~~
docker-compose up
~~~
