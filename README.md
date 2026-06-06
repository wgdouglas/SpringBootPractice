> # SpringBootPractice
~ Simple API with Spring Boot —> video used is `Spring Boot Tutorial | Full Course [2023] [NEW]
by amigoscode`

* The goal here is to implement an endpoint so that instead of getting the `Whitelabel Error Page` we will instead get back some Json data
* Within our main method class, we’ll add the Spring annotation of `@RestController` above the class name and under the `@SpringBootAPplication` annotation which will make this entire class now serve restful endpoints which we will add under and separate from the main method
    * Under the main method we’ll create a new String method called `hello()` that will return the string of “Hello World”
    * Now to make this method be served as a restful endpoint we have to annotate the method with a `@GetMapping( PostMapping, DeleteMapping, PutMapping, depending on what you want to do)`
    * Using the @GetMapping it basically means that we want to get something out of our server
    * Now since the @GetMapping is the only service call that we have even without adding a path we will see the return value in our browser once you start the server again
       > * **Now if you’d like to see Json data returned simply change the method to a List of String data type and then in the return pass in a `List.of()` two string objects separated by a comma and rerun the server to see the list returned as json data array
* Now we want to create a class that will be modeled after a student with certain attributes and behaviors
    * These students will represent a database
    * We will model it to also implement the student to be based off of everything from diagram number.1
    * The diagram below is how we’ll key in on what the model of our first student will look like
      Diagram Number.2
      ￼
      *the second age should say `email`

>  ****_Ch4. Student Class —>_****

* Now taking the student modeled in Diagram Number.2 we will create a class from it
* Once that student class is then built we will start to build our API with it from both Diagram Number 1 & 2
* First you’ll create a package called `student` inside your` src—> main` folders
    * Then you’ll create a class called Student & set the model up with the attributes of id, name, age, dob, email & pass in name, email, as Strings, age as an Integer, id as Long & dob as LocalDate
    * Fist you’ll set up three constructors
        * First on is a `No Args` / empty constructor
        * Second should have all attributes
        * The last one will not have the id since the db will generate the id for us
    * Now we’ll also set up our getters and setters inside our model for all of the attributes
    * Then just add a `toString()` & this will be all for the model right now
* Back inside of the main method class you’ll change our hello method to take in the data type of the Student class instead of a String
    * Then in the return’s list you’ll pass in a new instance of a Student matching the attributes that were set in the Student class (Note: when using the `Long` data type you just have to add the letter `L` after the value for it to be taken/accepted)
    * This will be the basic new student that we have created & when you run our server you’ll see the json data array with the info we put in in our browser.
    * Also, what we see in the browser means that our Student class was now converted into a Json Object as seen below
      ￼

* This diagram shows that our class was converted into a Json object which is the curly braces & the square brackets mean that a byte  is surrounding an array (the Json Object) 
* This is a basic Rest API Congratulations!!!! 🎉🎊🍾

>  ****_Ch5. API Layer —>_****

* The goal now is to essentially take our student model and put it into our Layers from Diagram Number.1 starting with an API Layer
* For this project we will be doing everything inside of our student package
    * We’ll start with creating our Controller class called `StudentController` which will have all of the resources for the API
    * What we’ll do now is move all of our API server call annotation from our main method class into the controller class (the @RestController & @GetMapping) & don’t forget to remove the unused imports
    * Now inside of the controller place the API annotations in the same places as they were in the main method class but you’ll also add under the @RestController the spring annotation of @RequestMapping since this will allow us to pass in a main path that will be used by our url for all of our server calls
    * **Note: Localhost will no longer call port 8080 it will call only `localhost:8080/api/v1/student`
    * Also we’ll now change our get method’s name from `hello()` to `getStudents()` since this is our get method the naming should reflect that action
        * With this the API layer is officially set up! Congratulations 🎊🎉🍾

>  ****_Ch6. Business Layer —>_****

* From Diagram Number.1 It’s understood that starting from the client, the client’s browser talks to the API layer, which then talks to the Service Layer which then talks to the Data Access Layer. Then starting at the Data Access Layer the service layer is getting from it & the API layer is the getting data from the service layer and we now have a healthy round trip
* Now moving the new student we passed into our getStudent() method we will now pass this logic into our Service layer
* The Service layer is mainly responsible for the business logic
    * First we’ll create a new class called `StudentService` &  take our getStudents() method and put it inside of our StudentService class
    * Then we’ll pass in the instance of StudentService into our controller class because now we’re trying to call that getStudents() method from inside of our service class & also add the StudentService class to a constructor we’ll have IntelliJ create inside of the controller class
    * **Note: set the instance as a `private final` inside the controller
    * Then inside of our getStudents() method in the controller we’ll pass in the field instance on the return which will then allow us to call the getStudents() method logic from our service class (this is called the N-tier patter)
    * Also, the return logic & new student that we’re using in the Service class is considered a static list but we want that student logic & info to come from a DB which we will soon set up

>  ****_Ch7. Dependency Injection —>_****

* How do you tell that an instance should be injected into a certain class/ constructor?
    * You use an injectable to do so
    * When you run the project now you get an error because the controller class’s constructor doesn’t know what instance of the service class to use. Yes we set the instance up but it still isn’t clear to the constructor. Thus we must use an injectable to tell our constructor what needs to be added to know which service we’re pointing to
    * To do this above the constructor we use the spring annotation of `@Autowireed` this basically say’s that the services that we have should be should be auto wired & instantiated  for you, then injected into the constructor
    * Then we have to tell our Service class that the class that we have for it has to be instantiated which just means it has to be a spring `Bean`
        * To do this in the service class above the class name you will use the spring annotation of `@Component` which now makes the service class a bean that our controller know’s it’s pointing to
        * For readability because this is a service class we will replace the `@Component` annotation with the other spring annotation of `@Service` (It’s the same thing just specifies the bean is for a service)
        * Congratulations 🎊🎉🍾 At this point now you have your API and Service Layers set up and exchanging data!!!!
          **Note: next phase will be focused on the Data Access Layer in which we want o connect to an actual DB & store the students into the DB & get it back out

****——> BIG NOTE: MAKE SURE THAT STUDENT PACKAGE IS INSIDE YOUR MAIN PACKAGE THAT HAS THE MAIN METHOD CLASS OR YOU WONT BE ABLE TO MAKE YOUR SERVICE CALLS****



>  ****_Ch8. Properties File —>_****

* Taking from Amigoscode’s GitHub repo on Springdata JPA —> src/main —> resources —> application.properties <copy all in file> `https://github.com/amigoscode/spring-data-jpa-course/blob/main/src/main/resources/application.properties`
*  Paste the configuration inside of your own application.properties file and update the url with `student` instead of amigoscode
* Leave username & password empty for local development
* The `ddl-auto` set to `create-drop` just means that you have a clean state every time the app is run
* You do want to show the SQL so keep it as `true`
* The dialect will stay `PostgrestSQL` since that is the dependency that we’re using for the DB
* We also do want to format the SQL so keep it as `true`
* Now to create a DB in PostgresSQL you’ll have to go to your terminal and input the below commands:
    * Connect to PostgreSQL: Open your terminal and connect to PostgreSQL using psql:
      ```shell
      psql -d postgres
      ```
    * Below steps 1-2 are for if you have already created a `student` PostgresSQL DB and want to create a new one
    * Step 1: Open your terminal and type in the command to access PostgresSQL
      ```shell
      psql
      ```
    * Step 2: This will list all of the databases that you have created so far
        ```shell 
        \l
        ```
    * Step 2b: Check Existing Databases: Run the following command to list all databases:
      * This will show all available databases. Verify if the database you want exists.
      * Run this if you return `psql: error: connection to server on socket "/tmp/.s.PGSQL.5432" failed: FATAL:  database "aa259537" does not exist
AB89142:SpringBootPractice User$ psql -l`
       ```shell 
       psql -l
       ```
    * Step 3: This will create a new database called `student`
      ```shell
      CREATE DATABASE student; 
      ```
    * Step 4: This will allow you to see all of the roles that you have created
      ```shell
      \du
      ```
    * Step 5: Now you want to grant all privileges to the database for the roles that you have created
      ```shell
      GRANT ALL PRIVILEGES ON DATABASE student TO <first role name in column>;
      GRANT ALL PRIVILEGES ON DATABASE student TO <second role name in column>;
      ```
    * Step 6: List out your databases again to see that the student database has been created
      ```shell
      \l
      ```
    * Step 7: Now you can connect to the student database that you just created
      ```shell
      \c student
      ```
    * Step 8: This will show you all of the tables that you have created in your DB
      * If you have not created any tables yet it will say `No relations found`
      ```shell
      \d
      ```
    * Remember: The `\l` allows you to see all of your created DB’s on your local
* Now go into the pom.xml and uncomment out the starter spa, reload maven & run your application
* Now in your your run terminal you can see the logs of how the connection went
* Next we need to add some tables to our DB which is next chapter

>  ****_Ch8. JPA & @Entity —>_****

* Now we want to take our created student & using Spring data JPA dependency to create a table inside of our PostgresSQL DB so that we can do all of our CRUD operations with Add, Delete, Post, Put, against the DB
* First inside of our Student Model class we’ll use the spring annotation `@Enitity & @Table` to map a student to our DB
    * The @Entity is for hibernate & @Table is for the table in our DB
    * Next Add the spring annotation of `@Id, @SequenceGenerator, & @GeneratedValue`
    * In @SequenceGenerator you’ll set the `name =  “student_sequence”, sequenceName =  “student_sequence” allocationSize = 1`
    * In the @GeneratedValue you’ll set the recommended strategy setting is `strategy = GenerationType.SEQUENCE, generator = “student_sequence”
        * This all basically means that the default generated value for Postgres is a sequence and the generator that we’ll use with Postgres is the sequence generator that we just created called “student_sequence”. Thus now you have now Mapped your student class to a table in your DB


>  ****_Ch9. JPA Repository —>_****

* First we’ll create a class called `StudentRepository` this is the naming convention for anything that will be accessing your DB mainly when working with JPA like now
* Set this as an interface class then extend it from spring reference of `JPARepository<>` & with this you have to specify the Object and ID types that you’ll be using and in this case it would be our Student class as our object and when you look inside of Student you see that we set our id value as a `Long` data type so we will use that in the Student Repository as well (ex: JPARepository<Student, Long>)
* Next we’ll use the Spring annotation of `@Repository` because this interface is responsible for data access and using this annotation will allow it to do so.
* Next we want to use this interface inside of our service
    * To do so we’ll insatiate StudentRepository inside of the service like we did in our controller class (Don’t forget to use @Autowired)
    * Now we want to remove the static list from our return and just use the interface. To do this we’ll return our field for the instance of the interface class and use the method option of `.findAll()` which returns a list to you
        * When you click into the spring annotation reference class of JPARepository and you’ll see that its an interface with a bunch of available methods passed in


>  ****_Ch10. Saving Students —>_****

* Now we want to add some students into our DB using the repository class
* First we’ll create a new class called `StudentConfig` which we’ll also add the spring annotation of the bean `@Configuration` since that’s the type we’re working with in this file
    * Using Spring instance of `CommandLineRunner` we’ll use this as our method called `commandLineRunner()` but we’ll be passing in no parameters inside the method
    * Then return an empty argument lambda expression
    * Also use the `@Bean` annotation for the method
    * Next is to set up access to our repository in our configuration class is to, pass in the Repository class into our method parameters
    * After this we’ll pass in our static list from the service into the return argument and extract a variable with the students name called `mariam`
    * Duplicate this to make a second student and rename them as `Alex`, but make sure to delete the id field from both students since we already set up a generator for those in the student model.
    * From here in order to see that both of these students have been saved to the DB we will pass in the field of `repository` from the repository class below the argument & set the method option to be `.saveAll()` and then pass in the list of the extracted variable names for both students `List.of(mariam, alex)`
    * Now when you run your application and look at the logs you’ll see it has displayed that the attributes we set for the table also has a `values` section which is the student
    * Also use the command `SELECT * FROM student;` in Postgres terminal or in the IDE plugin you’ll see the two students added
