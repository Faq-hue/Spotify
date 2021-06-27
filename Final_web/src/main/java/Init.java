import service.RecommendationsPodcast;
import service.RecommendationsSong;
import service.UploadTrack;
import service.UploadUser;

public class Init {
    public Init(){
        UploadTrack.uploadSong();
        UploadTrack.uploadPodcast();
        UploadUser.uploadConsumer();
        UploadUser.uploadCreator();
        RecommendationsSong.recommendationByNationality();
        RecommendationsSong.recommendationByPopularity();
        RecommendationsSong.recommendationByGender();
        RecommendationsSong.recommendationByArtist();
        RecommendationsPodcast.recommendationByNationality();
        RecommendationsPodcast.recommendationByPopularity();
        RecommendationsPodcast.recommendationByGender();
        RecommendationsPodcast.recommendationByArtist();


    }
}
