import java.util.List;
public class FP03MethodReferences {
  public static void main(String[] args) {
    List<String> courses = List.of(
        "Spring","Spring Boot","API","Microservices",
        "AWS","PCF","AZURE","Docker","Kubernetes","GIT"
    );
    
    courses.stream()
           //.map(str -> str.toUpperCase())   // convert each string to uppercase
           .map(String::toUpperCase)
           .forEach(System.out::println);   // print each one using method reference
  }
}

