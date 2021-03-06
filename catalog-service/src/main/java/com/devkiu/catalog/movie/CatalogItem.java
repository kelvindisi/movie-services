package com.devkiu.catalog.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogItem {
    private String name;
    private String description;
    private int rating;
}
