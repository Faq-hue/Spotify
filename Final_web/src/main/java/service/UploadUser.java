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
    public static void updateConsumer() {
        post("/updateConsumer", "application/json", (req, res) -> {
            Consumer c = new Gson().fromJson(req.body(), Consumer.class);
            return new ConsumerDAO().update(c.getId(),c);
        });
    }
    public static void updateCreator() {
        post("/updateCreator", "application/json", (req, res) -> {
            Creator c = new Gson().fromJson(req.body(), Creator.class);
            return new CreatorDAO().update(c.getId(),c);
        });
    }

}
