package com.example.serieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Series")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Serie {

    @Id
    private String id;
    private String name;
    private String genre;

    @JsonProperty("seasons")
    private List<Season> seasons = new ArrayList<>();

    public String getId() {
        return id;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Season {
        @JsonProperty("seasonNumber")
        private Integer seasonNumber;

        @JsonProperty("chapters")
        private List<Chapter> chapters = new ArrayList<>();

        @AllArgsConstructor
        @NoArgsConstructor
        @Setter
        @Getter
        public static class Chapter {

            private String name;
            private Integer number;
            private String urlStream;

        }
    }
}
