package com.example.test.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
public class Room {
    int roomNumber;
    String roomName;

    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }
}
