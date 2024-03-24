package com.dh.catalogservice.Model.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Serie {
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons = new ArrayList<>();

    public String getId() {
        return id;
    }

    public static class Season {
        private Integer seasonNumber;
        private List<Chapter> chapters = new ArrayList<>();


        public static class Chapter {

            private String name;
            private Integer number;
            private String urlStream;

        }
    }
}
