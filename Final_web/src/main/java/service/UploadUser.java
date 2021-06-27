package service;

import com.google.gson.Gson;
import dao.ConsumerDAO;
import dao.CreatorDAO;
import model.Consumer;
import model.Creator;


import static spark.Spark.post;

public class UploadUser {
    public static void uploadConsumer() {
        post("/uploadConsumer", "application/json", (req, res) -> {
            return new ConsumerDAO().add(new Gson().fromJson(req.body(), Consumer.class));
        });
    }

    public static void uploadCreator() {
        post("/uploadCreator", "application/json", (req, res) -> {
            return new CreatorDAO().add(new Gson().fromJson(req.body(), Creator.class));
        });
    }

}
