package com.benguiman.rockroom.model;

import android.net.Uri;

/**
 * @author benjamin.massello.
 */

public class User {
    private String name;
    private String email;
    private String id;
    private Uri photoUri;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.photoUri = builder.photoUri;
        this.id = builder.id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Uri getPhotoUri() {
        return photoUri;
    }

    public String getId() {
        return id;
    }

    public static class Builder {
        private String name;
        private String email;
        private String id;
        private Uri photoUri;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder photoUri(Uri photoUri) {
            this.photoUri = photoUri;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
