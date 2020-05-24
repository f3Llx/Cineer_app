package com.example.cineer.Movies_Trailer.Movies_upcoming;

public class Videos_result {

     private String id;
     private String iso_639_1;
     private String iso_3166_1;
     private String key;
     private String name;
     private String site;
     private float size;
     private String type;


     // Getter Methods

     public String getId() {
         return id;
     }

     public String getIso_639_1() {
         return iso_639_1;
     }

     public String getIso_3166_1() {
         return iso_3166_1;
     }

     public String getKey() {
         return key;
     }

     public String getName() {
         return name;
     }

     public String getSite() {
         return site;
     }

     public float getSize() {
         return size;
     }

     public String getType() {
         return type;
     }

     // Setter Methods

     public void setId(String id) {
         this.id = id;
     }

     public void setIso_639_1(String iso_639_1) {
         this.iso_639_1 = iso_639_1;
     }

     public void setIso_3166_1(String iso_3166_1) {
         this.iso_3166_1 = iso_3166_1;
     }

     public void setKey(String key) {
         this.key = key;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setSite(String site) {
         this.site = site;
     }

     public void setSize(float size) {
         this.size = size;
     }

     public void setType(String type) {
         this.type = type;
     }
}
