package com.devkiu.catalog.rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRating {
    private List<Rating> ratingList;
}
