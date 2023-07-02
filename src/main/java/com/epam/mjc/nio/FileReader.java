package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Paths;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try (Stream<String> lns = Files.lines(Paths.get(file.toURI()))) {
            return getProfileFromRawStrings(lns.toArray(String[]::new));
        } catch (IOException e) {
            throw new TestFileIncorrectException(e.getMessage());
        }
    }

    private Profile getProfileFromRawStrings(String[] strings) {
        Profile profile = new Profile();
        for (String str : strings) {
            String[] words = str.split(": ");
            switch (words[0]) {
                case "Name":
                    profile.setName(words[1]);
                    break;
                case "Age":
                    profile.setAge(Integer.parseInt(words[1]));
                    break;
                case "Email":
                    profile.setEmail(words[1]);
                    break;
                case "Phone":
                    profile.setPhone(Long.parseLong(words[1]));
                    break;
                default:
                    break;
            }
        }
        return profile;
    }
}