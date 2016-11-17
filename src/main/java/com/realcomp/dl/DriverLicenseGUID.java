package com.realcomp.dl;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Utility class to generate the DL GUID with the form "DL-{source}-{id}"
 */
public class DriverLicenseGUID{

    public static String generate(@NotNull DLRecord dl){
        Objects.requireNonNull(dl);
        return String.format("%s-%s-%s", "DL", dl.getSource(), dl.getId());
    }

    public static String generate(@NotNull String source, @NotNull String id){
        Objects.requireNonNull(source);
        Objects.requireNonNull(id);
        return String.format("%s-%s-%s", "DL", source, id);
    }
}
