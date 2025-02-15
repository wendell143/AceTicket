package com.example.demo3.dto;

public record AuthResponseDTO()
    {
        private static String accesstoken;
        private static String tokenType = "ticket";


        public  record nameOfRecord(String accesstoken,String tokenType)
        {

        }


    }
