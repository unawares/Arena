package com.example.theodore.arena.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Theodore on 4/24/18.
 */

public class User implements Parcelable {
    public enum Language {
        KAZ("KAZ"),
        RUS("RUS");

        private final String value;
        Language(String value) { this.value = value; }
        public String getValue() { return value; }
        public static Language fromString(String text) {
            for (Language item : Language.values()) {
                if (item.getValue().equals(text)) {
                    return item;
                }
            }
            return null;
        }
    }
    public enum Subject {
        MATH("MATH"),
        CHEMISTRY("CHEMISTRY"),
        PHYSICS("PHYSICS"),
        BIOLOGY("BIOLOGY"),
        GEOGRAPHY("GEOGRAPHY");

        private final String value;
        Subject(String value) { this.value = value; }
        public String getValue() { return value; }
        public static Subject fromString(String text) {
            for (Subject item : Subject.values()) {
                if (item.getValue().equals(text)) {
                    return item;
                }
            }
            return null;
        }
    }

    @NonNull String username = "";
    @NonNull String email = "";
    @NonNull String password = "";
    @NonNull Language language = Language.KAZ;
    @NonNull HashSet<Subject> subjects = new HashSet<>();

    public User() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(username);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(language.name());
        Object[] array = subjects.toArray();
        String[] stringArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            stringArray[i] = ((Subject) array[i]).getValue();
        }
        parcel.writeInt(stringArray.length);
        parcel.writeArray(stringArray);
    }

    private User(Parcel parcel) {
        username = parcel.readString();
        email = parcel.readString();
        password = parcel.readString();
        language = Language.valueOf(parcel.readString());
        int size = parcel.readInt();
        String[] stringArray = new String[size];
        parcel.readStringArray(stringArray);
        Subject[] items = new Subject[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            items[i] = Subject.fromString(stringArray[i]);
        }
        subjects = new HashSet<>(Arrays.asList(items));
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public HashSet<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashSet<Subject> subjects) {
        this.subjects = subjects;
    }
}