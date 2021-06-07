# Spring Data ORM JPA

### 1. Dependencies
We need to install below dependencies :
	- ORM Framework( Like Hibernate)
	- JDBC Connection Driver (My SQL driver example)
	- Spring Connector to Connect Hibernate and Spring
	- Spring Transaction to manage Transactions.
	- DB Connection pool manager


```
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
	<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.5.0.Final</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>5.3.7</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>5.3.7</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.25</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
		<dependency>
			<groupId>com.mchange</groupId>
			<artifactId>c3p0</artifactId>
			<version>0.9.5.5</version>
		</dependency>
```


Spring boot Starter JPA is the main dependency.

#####JPA : 
Java persistence api which provide specification for persisting, reading, managing data from your java object to relations in database.

#####Hibernate: 
There are various provider which implement jpa. Hibernate is one of them. So we have other provider as well. But if using jpa with spring it allows you to switch to different providers in future.

#####Spring Data JPA : 
This is another layer on top of jpa which spring provide to make your life easy.


Then we need to provide the properties in Application.properties that would help us to connect to the Database of our choice.

```
	spring.datasource.url=jdbc:mysql://localhost:3306/AirDb
	spring.datasource.username=root
	spring.datasource.password=Garima@16
	spring.jpa.hibernate.ddl-auto=create-drop
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
	spring.jpa.properties.hibernate.format_sql=true
	
```

### Spring JPA

#### 1. Entity
 - To create Entities we need to mark the class as @Entity
 - To Define primary keys, we need to tell @Id annotation.
 - If we want sequence to be generated , like in id field, we cam add @SequenceGenerator annotation.
 - We can add @column annotation with different parameters to define that it is column in the table.

Example of the same would be :

```
	@Entity(name="Student")
	@Table(name="Student",
			uniqueConstraints = {@UniqueConstraint(columnNames = {"Roll_No"})})
	public class Student {
		
		public Student() {
			super();
		}
	
		@Id
		@SequenceGenerator(
				name="student_sequence",
				sequenceName="student_sequence",
				allocationSize = 1)
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator="student_sequence")
		
		@Column(
				name = "Id",
				updatable = false
				)
		private int id;
		@Column(
				name = "Name",
				nullable = false,
				columnDefinition = "text"
				
				)
		private String name;
		@Column(
				name = "Roll_No",
				nullable = false
				)
		private int roll;
		@Column(
				name = "Address",
				nullable = false,
				columnDefinition = "text"
				
				)
		private String address;
```


#### 2. Repository

We will extend the JPA repositories which would help us in updating/Inserting etc(CRUD Operartions).

We can extend below :

	- JPA repository
	- Paging and Sorting Repository.
	- CRUD repository

After that we can perform our operations, JPA repository helps us in Flush and Batch functionalities as well.

Repo :

```
	package com.rajat.learning.repos;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Service;
	
	import com.rajat.learning.entities.Student;
	
	public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	

	}
	
```


Implementation of the Repo :

```
		@Controller
		public class ApplicationControllers {
			
			@Autowired
			StudentRepository srepo;
			
			@RequestMapping("/")
			public String home() {
				return "Home Page";
			}
			
			@PostMapping("/addStudent")
			public boolean addStudent(@RequestBody Student s1) {
				
				srepo.save(s1);
				return true;
				
			}
		
		}
		
```













