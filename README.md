# springboot-webservice



* DB
  * postgreSQL
* Entity 클래스
  * DB 테이블에 매칭되는 클래스
  * @Entity 선언
  * @Id, @GeneratedValue, @Column 등으로 테이블의 열 정의
* JpaRepository
  * DB에 데이터를 CRUD하는 계층
  * SpringDataJpa에서 제공하지 않는 메소드는 @Query로 작성
* DTO
  * 계층간 전달데이터 객체
* Service 
  * @Service 선언
  * Repository를 주입받아 비즈니스 로직을 처리함
  * 적절한 DTO 객체를 리턴하여 데이터를 전달할 수 있음

***

* Controller, RestController

  * view 관여 여부에 따라 구분했음

* JpaAuditing

  * Entity들의 createdDate, modifiedDate를 자동으로 관리

  * application 클래스에 @EnableJpaAuditing 추가

  * Entity들이 extends 하는 클래스 생성

  * ```java
    @Getter
    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public class BaseTimeEntity {
    	@CreatedDate    private LocalDateTime createdDate;
        @LastModifiedDate    private LocalDateTime modifiedDate;
    }
    ```

* application.yml

  * application.properties에 비해 가독성이 좋음

* Handlebars

  * Thymeleaf와 함께 꾸준히 업데이트 되고 있는 뷰 엔진
  * 문법이 비교적 간단함
  * 로직 코드 사용이 불가능하여 view와 서버의 역할을 제한

* 외부 javascript

  * HTML과 코드를 분리
  * 캐시화된 javascript 파일들은 더 빠른 페이지 로드를 가능하게 함
  * javascript 객체화를 통해 논리적으로 간단하게 사용가능



# this was assisted by https://jojoldu.tistory.com