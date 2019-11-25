package com.namankhurpia.paper.view.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schema {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("course_name")
        @Expose
        private String courseName;
        @SerializedName("course_code")
        @Expose
        private String courseCode;
        @SerializedName("slot")
        @Expose
        private String slot;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("data_dir")
        @Expose
        private String dataDir;
        @SerializedName("relative_path")
        @Expose
        private String relativePath;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        public String getSlot() {
            return slot;
        }

        public void setSlot(String slot) {
            this.slot = slot;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getDataDir() {
            return dataDir;
        }

        public void setDataDir(String dataDir) {
            this.dataDir = dataDir;
        }

        public String getRelativePath() {
            return relativePath;
        }

        public void setRelativePath(String relativePath) {
            this.relativePath = relativePath;
        }


}
