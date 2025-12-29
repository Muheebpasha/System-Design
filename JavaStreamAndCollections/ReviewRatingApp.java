import java.util.*;
import java.time.LocalDateTime;

class Review {
    private static long idCounter = 0;
    private final long reviewId;
    private long productId;
    private long userId;
    private int rating; // 1 to 5 scale
    private String title;
    private String reviewText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Review(long productId, long userId, int rating, String title, String reviewText) {
        this.reviewId = ++idCounter;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.title = title;
        this.reviewText = reviewText;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    // Getter and Setter methods
    public long getReviewId() { return reviewId; }
    public long getProductId() { return productId; }
    public long getUserId() { return userId; }
    public int getRating() { return rating; }
    public String getTitle() { return title; }
    public String getReviewText() { return reviewText; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setRating(int rating) {
        this.rating = rating;
        this.updatedAt = LocalDateTime.now();
    }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

class ReviewService {
    private final Map<Long, List<Review>> productReviews = new HashMap<>();

    // Add a new review
    public void addReview(Review review) {
        productReviews.computeIfAbsent(review.getProductId(), k -> new ArrayList<>()).add(review);
    }

    // Get reviews for a product
    public List<Review> getReviewsForProduct(long productId) {
        return productReviews.getOrDefault(productId, Collections.emptyList());
    }

    // Get average rating for a product
    public double getAverageRating(long productId) {
        List<Review> reviews = productReviews.get(productId);
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Review r : reviews) {
            sum += r.getRating();
        }
        return (double) sum / reviews.size();
    }

    // Update a review by reviewId
    public boolean updateReview(long reviewId, int rating, String title, String reviewText) {
        for (List<Review> reviews : productReviews.values()) {
            for (Review r : reviews) {
                if (r.getReviewId() == reviewId) {
                    r.setRating(rating);
                    r.setTitle(title);
                    r.setReviewText(reviewText);
                    return true;
                }
            }
        }
        return false;
    }

    // Delete a review by reviewId
    public boolean deleteReview(long reviewId) {
        for (List<Review> reviews : productReviews.values()) {
            Iterator<Review> iterator = reviews.iterator();
            while (iterator.hasNext()) {
                Review r = iterator.next();
                if (r.getReviewId() == reviewId) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }
}

public class ReviewRatingApp {
    public static void main(String[] args) {
        ReviewService service = new ReviewService();

        // Adding reviews
        Review r1 = new Review(101, 201, 5, "Great product", "I loved using this product.");
        Review r2 = new Review(101, 202, 4, "Good value", "Worth the money.");
        Review r3 = new Review(102, 203, 3, "Average", "It's okay.");

        service.addReview(r1);
        service.addReview(r2);
        service.addReview(r3);

        // Display reviews for product 101
        System.out.println("Reviews for product 101:");
        for (Review r : service.getReviewsForProduct(101)) {
            System.out.println(r);
        }

        // Average rating for product 101
        System.out.println("Average rating for product 101: " + service.getAverageRating(101));

        // Update a review
        service.updateReview(r2.getReviewId(), 5, "Excellent value", "Exceeded expectations.");

        // Delete a review
        service.deleteReview(r3.getReviewId());

        // Display updated reviews for product 101
        System.out.println("Updated reviews for product 101:");
        for (Review r : service.getReviewsForProduct(101)) {
            System.out.println(r);
        }

        // Display reviews for product 102 (after deletion)
        System.out.println("Reviews for product 102:");
        for (Review r : service.getReviewsForProduct(102)) {
            System.out.println(r);
        }
    }
}

