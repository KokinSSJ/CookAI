package com.asugo.cookai;

import java.util.List;

public record CookCommand(
        List<Ingredient> ingredients,
        String diet,
        String mealType) {


    public static CookCommand from(CookAssistantRequest request) {
        return new CookCommand(request.ingredients(), request.diet(), request.mealType());
    }

}