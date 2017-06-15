package com.benguiman.rockroom.view.model;

/**
 * @author benjamin.massello.
 */

public class RoomViewModel {
    private final String id;
    private final String name;
    private final String address;
    private final String photoUrl;
    private final String ownerId;

    private RoomViewModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.photoUrl = builder.photoUrl;
        this.ownerId = builder.ownerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public static class Builder {
        private String id = null;
        private String name;
        private String address;
        private String photoUrl;
        private String ownerId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder photoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public RoomViewModel build() {
            return new RoomViewModel(this);
        }
    }
}
