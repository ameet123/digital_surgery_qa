## Load Testing
This application performs simple load testing against API Services
It demonstrates using 2 approaches,

### Approaches

#### Test
```bash
sbt gatling:test
```
#### Uber Jar
```bash
sbt assembly
java -cp './target/scala-2.12/digital_surgery_qa-assembly-0.1.jar' io.gatling.app.Gatling -s com.jnj.surgery.qa.MainTester
```