# toy dev

두번째 커밋 내용
1. jpa - mysql에 테이블 생성 추가 
   1. application 에 추가 
      1. @EnableJpaRepositories(basePackages = {"com.example.toy"})
      2. @EntityScan(basePackages ={"com.example.toy"})


2. Could not autowire. No beans of 'Repository' type found ... 
   1. @Autowired error 
      1. @ComponentScan(basePackages = {"com.example.toy"}) 추가

3. Lombok 의존성 추가