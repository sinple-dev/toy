# toy dev
take. 9
container config
ajp connector 추가 - 필요여부 확인해야해

take.8
store, axios 설정 ~ing

take.7
스프링 버전 최신으로 변경(2.6.4)
web axios 설정 ~ing

take.6
1. 스프링부트 target 폴더 ignore, delete

take.5
1. 원격저장소 idea 폴더 삭제

take.4
1. 제일바깥 gitignore 추가
   1. .idea ignore 되어라!
   
take.3

두번째 커밋 내용
1. jpa - mysql에 테이블 생성 추가 
   1. application 에 추가 
      1. @EnableJpaRepositories(basePackages = {"com.example.toy"})
      2. @EntityScan(basePackages ={"com.example.toy"})


2. Could not autowire. No beans of 'Repository' type found ... 
   1. @Autowired error 
      1. @ComponentScan(basePackages = {"com.example.toy"}) 추가

3. Lombok 의존성 추가