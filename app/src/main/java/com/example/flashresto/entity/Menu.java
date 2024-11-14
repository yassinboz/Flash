package com.example.flashresto.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
    @Entity(tableName = "menu")

    public class Menu {
        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "plat")
        private String plat;

        @ColumnInfo(name = "description")
        private String description;

        @ColumnInfo(name = "prix")
        private int prix;
        @ColumnInfo(name = "rating")
        private float rating;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        public float getRating() {
            return rating;
        }

        public void setRating(float rating) {
            this.rating = rating;
        }

        public String getPlat() {
            return plat;
        }

        public void setPlat(String plat) {
            this.plat = plat;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrix() {
            return prix;
        }

        public void setPrix(int prix) {
            this.prix = prix;
        }

        public Menu(int id, String plat, String description, int prix) {
            this.id = id;
            this.plat = plat;
            this.description = description;
            this.prix = prix;
        }

        public Menu(int id, String plat, String description, int prix, float rating) {
            this.id = id;
            this.plat = plat;
            this.description = description;
            this.prix = prix;
            this.rating = rating;
        }

        public Menu(String plat, String description, int prix, float rating) {
            this.plat = plat;
            this.description = description;
            this.prix = prix;
            this.rating = rating;
        }

        public Menu(String plat, String description, int prix) {
            this.plat = plat;
            this.description = description;
            this.prix = prix;
        }
        public Menu (){

        }
}
