public enum SQLCredentials {
    URL("jdbc:mysql://localhost:3306/sallu_db"),
    USERNAME("root"),
    PASSWORD("salman123");
    final String value;
    SQLCredentials(String value) {
        this.value = value;
    }
}
