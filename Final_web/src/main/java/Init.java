import service.*;

public class Init {
    static{
        UploadTrack.uploadSong();
        UploadTrack.updateSong();
        UploadTrack.uploadPodcast();
        UploadTrack.updatePodcast();
        UploadUser.uploadConsumer();
        UploadUser.updateConsumer();
        UploadUser.uploadCreator();
        UploadUser.updateCreator();
        RecommendationsSong.recommendationByNationality();
        RecommendationsSong.recommendationByPopularity();
        RecommendationsSong.recommendationByGender();
        RecommendationsSong.recommendationByArtist();
        RecommendationsPodcast.recommendationByNationality();
        RecommendationsPodcast.recommendationByPopularity();
        RecommendationsPodcast.recommendationByGender();
        RecommendationsPodcast.recommendationByArtist();
        Others.uploadPlaylist();
        Others.getListUser();
        Others.getListTrack();

    }
}
