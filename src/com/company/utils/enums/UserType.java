package com.company.utils.enums;

public enum UserType {

        User("user"),
        Critic("critic"),
        Expert("expert"),
        Admin("admin");

        private String text;

        UserType(String text) {
                this.text = text;
        }

        public String getText() {
                return this.text;
        }

        public static UserType fromString(String text) {
                for (UserType b : UserType.values()) {
                        if (b.text.equalsIgnoreCase(text)) {
                                return b;
                        }
                }
                return null;
        }
}
