package com.demo.generator;

import com.demo.types.MeetUp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetEvent  {

        private GetEvent() throws IOException{
            MeetUp meetUp  = new MeetUp();
            ObjectMapper objectMapper = new ObjectMapper();
            String data2;
            URL data = new URL("http://stream.meetup.com/2/rsvps");
            while (data != null) {
                try(BufferedReader input = new BufferedReader(
                        new InputStreamReader(data.openStream()))){
                    meetUp = objectMapper.readValue(input, meetUp.getClass());
                    System.out.println(meetUp.getMember().getMemberName());
                }
             }
        }
}

