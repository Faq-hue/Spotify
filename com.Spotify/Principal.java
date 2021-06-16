import service.RecommendationsSong;

public class Principal {

  public static void main(String[] args) {
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByPopularity());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByNationality());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByArtist());
    System.out.println("--------------------------------------------------------------------");
    System.out.println(RecommendationsSong.recommendationByGender());
    System.out.println("--------------------------------------------------------------------");
  }

}