import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {

  private String name;
  private String category;
  private int reviewScore;
  private int noOfStudents;

  public Course(String name, String category, int reviewScore, int noOfStudents) {
    this.name = name;
    this.category = category;
    this.reviewScore = reviewScore;
    this.noOfStudents = noOfStudents;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public int getReviewScore() {
    return reviewScore;
  }
  public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
  }
  public int getNoOfStudents() {
    return noOfStudents;
  }
  public void setNoOfStudents(int noOfStudents) {
    this.noOfStudents = noOfStudents;
  }

  @Override
  public String toString() {
      return String.format("%s:%d:%d", name, noOfStudents, reviewScore);
  }
  
}
class FP04CustomClass {
  public static void main(String[] args) {
    List<Course> courses = List.of(
      new Course("Spring", "Framework", 98, 2000),
      new Course("Spring Boot", "Framework", 95, 18000),
      new Course("React-js", "Framework", 98, 42000),
      new Course("API", "Microservices", 97, 22000),
      new Course("Inter-Service Communication", "Microservices", 96, 25000),
      new Course("Service Discovery with Eureka", "Microservices", 92, 24000),
      new Course("Java Full Stack ", "Full Stack", 91, 14000),
      new Course("MERN Stack ", "Full Stack", 89, 16000),
      new Course("PHP Full Stack ", "Full Stack", 61, 500),
      new Course("AWS", "Cloud", 91, 21000),
      new Course("Azure", "Cloud", 99, 21000),
      new Course("Docker", "DevOps",92, 2000),
      new Course("Kubernetes", "DevOps", 91, 2000)
    );

    //allMatch, anyMatch and noneMatch

    Predicate<Course> reviewScoreGreaterThan95predicate = course -> course.getReviewScore() > 95;

    Predicate<Course> reviewScoreGreaterThan90predicate = course -> course.getReviewScore() > 90;

    Predicate<Course> reviewScoreLessThan90predicate = course -> course.getReviewScore() < 90;

    boolean isTrue = courses.stream().allMatch(reviewScoreGreaterThan95predicate);
    System.out.println("All Match reviewScoreGreaterThan95predicate : "+ isTrue);


    isTrue = courses.stream().allMatch(reviewScoreGreaterThan90predicate);
    System.out.println("All Match Predicate reviewScoreGreaterThan90predicate :" + isTrue);

    isTrue = courses.stream().noneMatch(reviewScoreGreaterThan90predicate);
    System.out.println("None Match reviewScoreGreaterThan90predicate : "+ isTrue);

    isTrue = courses.stream().noneMatch(reviewScoreGreaterThan95predicate);
    System.out.println("None Match reviewScoreGreaterThan95predicate : "+ isTrue);

    isTrue = courses.stream().noneMatch(reviewScoreLessThan90predicate);
    System.out.println("None Match reviewScoreLessThan90predicate : "+ isTrue);

    isTrue = courses.stream().anyMatch(reviewScoreLessThan90predicate);
    System.out.println("Any Match reviewScoreLessThan90predicate : "+ isTrue);

    isTrue = courses.stream().anyMatch(reviewScoreGreaterThan95predicate);
    System.out.println("Any Match reviewScoreGreaterThan95predicate : "+ isTrue);

    isTrue = courses.stream().anyMatch(reviewScoreGreaterThan95predicate);
    System.out.println("Any Match reviewScoreGreaterThan95predicate : "+ isTrue);

    Comparator<Course> comparingByNoOfStudentsIncreasingOrder = Comparator.comparingInt(Course::getNoOfStudents);

    List<Course> sortedCourses = courses.stream().sorted(comparingByNoOfStudentsIncreasingOrder).collect(Collectors.toList());

    System.out.println("Sorted Course List ASC : "+ sortedCourses);

    Comparator<Course> comparingByNoOfStudentsDecreasingOrder = Comparator.comparingInt(Course::getNoOfStudents).reversed();
    sortedCourses = courses.stream().sorted(comparingByNoOfStudentsDecreasingOrder).collect(Collectors.toList());
    System.out.println("Sorted Course List DESC : "+ sortedCourses);

    Comparator<Course> comparingByNoOfStudentsAndNoOfReviews 
                = Comparator.comparing(Course::getNoOfStudents)
                            .thenComparing(Course::getReviewScore)
                            .reversed();

    sortedCourses = courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList());

    System.out.println("Sorted Course with comparingByNoOfStudentsAndNoOfReviews : " + sortedCourses);
    
    sortedCourses = courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).limit(5).collect(Collectors.toList());

    System.out.println("Top 5 Course with comparingByNoOfStudentsAndNoOfReviews : " + sortedCourses);

    sortedCourses = courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(2).limit(1).collect(Collectors.toList());

    System.out.println("3rd highest Course with comparingByNoOfStudentsAndNoOfReviews : " + sortedCourses);

    
    sortedCourses = courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList());

    System.out.println("Get courses while getReviewScore() >= 95 : " + sortedCourses);

    sortedCourses = courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList());

    System.out.println("Skip Courses while getReviewScore() >= 95 : " + sortedCourses);

    // Optional<Course> maxCourse = courses.stream().max(Comparator.comparing(Course::getNoOfStudents)
    //                         .thenComparing(Course::getReviewScore));

    // if (maxCourse.isPresent()) {
    //     System.out.println("Max course: " + maxCourse.get());
    // } else {
    //     System.out.println("No course found!");
    // }

    System.out.println(courses.stream()
                    .max(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore)));
                   
    System.out.println(courses.stream()
                    .min(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore)));

    System.out.println(courses.stream()
                    .filter(reviewScoreLessThan90predicate)
                    .min(comparingByNoOfStudentsAndNoOfReviews));

    System.out.println(courses.stream()
                    .filter(reviewScoreLessThan90predicate)
                    .min(comparingByNoOfStudentsAndNoOfReviews)
                    .orElse(new Course("Kubernetes", "Cloud", 91, 2000)));

    System.out.println(courses.stream()
                        .filter(reviewScoreGreaterThan95predicate)
                        .findFirst());

    System.out.println(courses.stream().filter(reviewScoreGreaterThan95predicate).findAny());
                         

    System.out.println(courses.stream().filter(reviewScoreGreaterThan95predicate).mapToInt(Course::getNoOfStudents).sum());

    System.out.println(courses.stream().filter(reviewScoreGreaterThan95predicate).mapToInt(Course::getNoOfStudents).average());

    System.out.println(courses.stream().filter(reviewScoreGreaterThan95predicate).mapToInt(Course::getNoOfStudents).count());

    System.out.println(courses.stream().filter(reviewScoreGreaterThan95predicate).mapToInt(Course::getNoOfStudents).max());

    Map<String, List<Course>> courseByCategory =  courses.stream().collect(Collectors.groupingBy(Course::getCategory));

    System.out.println("Group By Category : \n" + courseByCategory);

    Map<String, Long> courseByCategoryWithCount = courses.stream()
                          .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));

    System.out.println("Course by Category with count :\n " + courseByCategoryWithCount);

    Map<String,List<String>> courseNamesByCategory = courses.stream()
                              .collect(Collectors.groupingBy(
                                Course::getCategory, 
                                Collectors.mapping(Course::getName, Collectors.toList())
                                ));

    System.out.println("Course by category with course name. \n" + courseNamesByCategory);

    Map<String, Map<String, Object>> summary = courses.stream()
                                      .collect(Collectors.groupingBy(
                                          Course::getCategory,
                                          Collectors.collectingAndThen(
                                              Collectors.mapping(Course::getName, Collectors.toList()),
                                              names -> {
                                                  Map<String, Object> result = new HashMap<>();
                                                  result.put("names", names);
                                                  result.put("count", names.size());
                                                  return result;
                                              }
                                          )
                                      ));

    System.out.println("Course Summary : \n" + summary);

    Map<String, Optional<Course>> topRatedCourseByCategory = courses.stream()
                                  .collect(Collectors.groupingBy(
                                    Course::getCategory,
                                    Collectors.maxBy(Comparator.comparing(
                                      Course::getReviewScore))
                                  ));

   
    System.out.println("Top Rated Course By Category :\n" + topRatedCourseByCategory);

       Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
       Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);
  }

  private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
      return course -> course.getReviewScore() > cutoffReviewScore;
  }
}
