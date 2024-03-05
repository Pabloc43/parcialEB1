package com.dh.catalogservice.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private Long id;

    private String name;

    private String genre;

    private String urlStream;

}
