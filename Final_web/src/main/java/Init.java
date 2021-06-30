import service.*;

public class Init {
    static{
        Remove.removeUser();
        Remove.removePlayList();
        Remove.removeTrack();
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
        Search.songSearch();
        Play.playTrack();
    }
}
