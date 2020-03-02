##### OpenShift

---

* OpenShift란
  * RedHat에서 개발한 Paas 솔루션
  * Docker와 Kubernetes를 제공하는 컨테이너 애플리케이션 플랫폼
  * enterprise-grade의 다양한 부가 기능이 추가되어, Web-UI, 소스 빌드 자동화, 라우터 등을 사용 가능하도록 제공
  * 57개 이상의 프로젝트 템플릿을 제공하여 즉시 Docker용 애플리케이션 빌하여 실행 가능
  * 신속한 애플리케이션 개발을 위해 도커 컨테이너와 DevOps 도구를 사용하여 쿠버네티스를 지원하는 운영환경을 제공하는 것
* 아키텍처
  * 오픈시프트에 구축되는 시스템 환경은 여러 Node(RHEL,Red Hat Enterprise Linux )로 구성됨
  * Node에는 Pod을 배치
  * Pod이란
    * 쿠버네티스가 컨테이너들을 관리하기 위한 논리 단위 & 오픈시프트에서 관리하는 가장 작은 단위
    * 하나의 Pod에 N개의 컨테이너를 배포할 수 있음
    * Pod은 Master(Kubernetes 구현을 확장한 OpenShift Enterprise 관리 서버)에 의해 자동( 설치, 부하 모니터링, 오류 감지, 모니터 등)에 관리
  * 버전 관리 시스템의 커밋 이벤트(hook)를 통해 애플리케이션을 자동으로 Docker이미지에 빌드 및 배포 가능
  * 라우팅 레이어를 통해 애플리케이션에 접속 가능
  * SCM(Source Code Management)의 커밋이벤트로 애플리케이션을 자동으로 이미지로 빌드하여 배포 가능

![img](https://k.kakaocdn.net/dn/AC7Q6/btqA5QndY31/kI828h0RVpmVknRbVKYSG0/img.png)

* 특징

  * 컨테이너 이미지 
    * 다양한 미들웨이 및 DB이미지 사용가능
  * DevOps
    * Eclipse IDE Plugin을 통한 개발/테스트 지원
    * Git과 Jenkins를 통한 CI/CD 구성 지원
  * App 배포
    * 빌드 배포 및 자동화 지원
    * Roll back 방법 제공
  * 서비스 확장
    * HA Proxy 기반의 Load Balancing 제공
    * Auto Scaler를 통한 부하 상황에 알맞는 확장 제공
  * 모니터링
    * 애플리케이션 로그 모니터링 제공
    * Pod Cpu, Memory 모니터링 제공

* DevOps

  * S2I빌드 및 배포

  ![1](https://user-images.githubusercontent.com/15958325/54922737-221dd500-4f4c-11e9-9669-75c08fa8d184.png)

  * Git과 Jenkins를 통한 CI/CD구성 지원 : 개발/ 스테이징에 빌드, 테스트, 배포를 자동화
    * CI(Continuous Integration) : 여러명의 개발자가 개발한 소스를 지속적으로 통합하는 것
    * CD(Continuous Delivery) : 빌드 결과물을 지속적으로 전달해서 제품의 질적 향상을 꾀하는것
  * 배포 내역 관리 및 편리한 Rollback
  * Auto Scaling기능 제공
    * 서비스를 수행하는 pod에 부하가 발생하여 cpu사용률이 중가한다면 자동으로 pod을 추가로 생성하여 확장
  * 모니터링

* OpenShift와 Kubernetes의 차이점

  * Kubernetes는 오픈소스 프로젝트, OpenShift는 제품

* Kubernetes와 Docker의 차이

  * Docker

    * 컨테이너 기반의 오픈소스 가상화 플랫폼

    ![VM vs Container](https://developer.ibm.com/kr/wp-content/uploads/sites/98/container1-1.png)

    * 컨테이너 : 애플리케이션& 애플리케이션을 구동하는 환경을 격리한 공간
    * 자원을 필요한만큼 격리하여 컨테이너에 할당

  * Kubernetes

    * 컨테이너 오케스트레이션 툴
      * 컨테이너를 스케줄링/ 클러스터링/ 서비스 디스커버리/ 로깅 및 모니터링
    * 점진적 업데이트 제공 -> 서비스 중단없이 업데이트 가능
    * 특정 컨테이너가 죽었다면 즉각 그 컨테이너를 복제 생성해서 서비스를 유지
    * 
