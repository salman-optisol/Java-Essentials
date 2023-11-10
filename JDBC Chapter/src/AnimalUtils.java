import java.sql.*;

public class AnimalUtils {
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(SQLCredentials.URL.value, SQLCredentials.USERNAME.value, SQLCredentials.PASSWORD.value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void insertAnimal(String animalName, String animalType) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO animals(animal_name, animal_type) VALUES(?,?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, animalName);
            statement.setString(2, animalType);
            int rowsAffected = statement.executeUpdate();

            System.out.println("Successfully inserted " + rowsAffected + " records!");
            ResultSet generatedKeys = statement.getGeneratedKeys();

            while (generatedKeys.next()) {
                showAnimal(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     static void showAnimal(int animalId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM animals WHERE animal_id = ?");
            statement.setInt(1, animalId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt("animal_id"));
                System.out.println("Name : " + resultSet.getString("animal_name"));
                System.out.println("Type : " + resultSet.getString("animal_type"));
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        insertAnimal("Lion", "Carnivores");
        insertAnimal("Goat", "Herbivores");
        insertAnimal("Tiger", "Carnivores");
        insertAnimal("Camel", "Herbivores");
    }
}
