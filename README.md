# BE_public


# 파일 구조		


	.azure
	.mvn
	└wrapper
	src
	└main
	  └java
	    └com    
	      └example      
	        └TRYBE	
	          └controller	  
	          └entities	  
	          └models	  
	          └repos	  
	          └services	  
	          └user	  
	           Prompts.java	   
	           TrybeApplication.java	   
	    └resources    
	     application.prop.example		*작성 필요([1] application.prop.example 작성 방법 참고)     
	└test
	└java
	    └com    
	      └example      
	        └TRYBE	
	.gitignore
	README.md
	mvnw.cmd
	pom.xml



# 작성 방법	


[1] application.prop.example 작성 방법

파일 내용이 예시임을 표현하기 위해 application.prop.example로 작성했으므로 실제 구현시에는 파일명을 application.properties로 수정해야함.

	// Database configuration
 
	spring.datasource.url = jdbc:mysql://your-database-url:3306/your-database-name
	// your-database-name에 azure에서 생성한 데이터베이스의 스키마 명을 입력
	spring.datasource.username = your-username
	// your-username에 데이터베이스의 사용자명을 입력
	spring.datasource.password = your-password
	// your-password에 데이터베이스 사용자의 비밀번호를 입력
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


	// Hibernate configuration
 
	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
	spring.jpa.hibernate.ddl-auto=update


	// OpenAI secret key
 
	openai.secret-key= your-secret-key
	// your-secret-key에 OPENAI 인증키를 입력

 
	// Swagger UI configuration
 
	springdoc.swagger-ui.tags-sorter=alpha
	springdoc.swagger-ui.operations-sorter=alpha
	springdoc.swagger-ui.default-models-expand-depth=2


# 샘플 데이터

[1] 모의고사 데이터
시험 출제 기관에서 제공하는 모의고사 정보를 유형별로 나누어 저장하였다.

[2] 뉴스 데이터
매번 새로운 주제로 출제되는 토플 스피킹에 대비하기 위해 다양한 주제의 영문 기사를 선별해 저장해두었다. 실제 토플 스피킹에 가장 높은 빈도로 출제되는 biology 분야의 기사를 다른 분야의 기사보다 많이 저장해 토플 스피킹 시험 대비에 더욱 도움이 될 수 있도록 하였다.


# 실행 방법

모든 파일을 제대로 작성한 뒤, 아래의 [1]번 링크의 내용을 참고해 데이터 베이스와 연결한다. 그 후, Application.java 파일에서 프로젝트를 실행시켜 로컬에서 서버를 실행하거나 아래의 [2]번 링크의 내용을 참고해 클라우드에 서버를 올려 실행할 수 있다.

[1] 데이터베이스와 백엔드 서버 연결에 대한 기술 블로그
https://velog.io/@hf92304/Spring-boot-MySQL-데이터베이스-연결하기

[2] Azure Spring Apps 공식 문서
https://learn.microsoft.com/ko-kr/azure/spring-apps/enterprise/quickstart?tabs=Azure-portal%2CIntelliJ%2CConsumption-workload&pivots=sc-enterprise
