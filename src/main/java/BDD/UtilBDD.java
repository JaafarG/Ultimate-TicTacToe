package BDD;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.example.ultimatetictactoe.Player;
import org.example.ultimatetictactoe.Game;

public class UtilBDD {
    private static final String URL = "jdbc:mysql://192.168.112.1:3306/ultimate_tic_tac_toe";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /* ========= Gestion de la base de données ========= */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private static void createDatabase() {
        String[] requetesSuppression = {
                "DROP TABLE IF EXISTS Score",
                "DROP TABLE IF EXISTS Game",
                "DROP TABLE IF EXISTS Player"
        };

        String[] requetesCreation = {
                """
                CREATE TABLE IF NOT EXISTS Player(
                   IDPlayer INT AUTO_INCREMENT,
                   Username VARCHAR(15) NOT NULL UNIQUE,
                   Password VARCHAR(100),
                   ProfileCreationDate DATE,
                   PRIMARY KEY(IDPlayer)
                );
                
                CREATE TABLE IF NOT EXISTS Game(
                   IDGame INT AUTO_INCREMENT,
                   GameDate DATETIME,
                   Finished BOOLEAN,
                   IDWinner INT,
                   IDPlayerX INT NOT NULL,
                   IDPlayerO INT NOT NULL,
                   PRIMARY KEY(IDGame),
                   FOREIGN KEY(IDPlayerX) REFERENCES Player(IDPlayer),
                   FOREIGN KEY(IDPlayerO) REFERENCES Player(IDPlayer)
                );
                
                CREATE TABLE IF NOT EXISTS Score(
                   IDPlayer INT,
                   IDOpponent INT,
                   NumberGames INT DEFAULT 0,
                   NumberWins INT DEFAULT 0,
                   NumberLosses INT DEFAULT 0,
                   PRIMARY KEY(IDPlayer, IDOpponent),
                   FOREIGN KEY(IDPlayer) REFERENCES Player(IDPlayer),
                   FOREIGN KEY(IDOpponent) REFERENCES Player(IDPlayer)
                );"""
        };

        try (Connection c = getConnection();
             Statement stmt = c.createStatement()) {

            for (String requete : requetesSuppression) {
                stmt.execute(requete);
            }

            for (String requete : requetesCreation) {
                stmt.execute(requete);
            }

            System.out.println("Database successfully created.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in database creation : " + e.getMessage());
        }
    }


    /* ------------------------- SCRUD ------------------------- */

    /* ~~~~~~~~~~~~ Search ~~~~~~~~~~~~ */
    public static boolean playerExist(int IDPlayer) {
        String sql = "SELECT COUNT(IDPlayer) FROM Player WHERE IDPlayer = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, IDPlayer);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean playerExist(String username) {
        String sql = "SELECT COUNT(IDPlayer) FROM Player WHERE Username = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean gameExist(int IDGame) {
        String sql = "SELECT COUNT(IDGame) FROM Game WHERE IDGame = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, IDGame);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean scoreExist(int IDPlayer, int IDOpponent) {
        String sql = "SELECT COUNT(*) FROM Score WHERE IDPlayer = ? AND IDOpponent = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, IDPlayer);
            ps.setInt(2, IDOpponent);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /* ~~~~~~~~~~~~ Create ~~~~~~~~~~~~ */
    public static boolean insertPlayer(String username, String password) {
        if (playerExist(username)) {
            System.out.println("This player's username already exists.");
        } else {
            try {
                Connection c = getConnection();
                String sql = "INSERT INTO Player (IDPlayer, Username, Password, ProfileCreationDate) VALUES (NULL, ?, ?, ?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.executeUpdate();
                System.out.println("Player successfully inserted in the database !");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean insertGame(Game game) {
        if (gameExist(game.getIDGame())) {
            System.out.println("This game's ID already exists.");
        } else {
            try {
                Connection c = getConnection();
                String sql = "INSERT INTO Game (IDGame, GameDate, Finished, IDWinner, IDPlayerX, IDPlayerO) VALUES (?, ?, ?, NULL, ?, ?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, game.getIDGame());
                ps.setTimestamp(2, game.getGameDate()); // Assurez-vous que getGameDate() renvoie un Timestamp
                ps.setBoolean(3, false);
                if (game.getPlayers()[0].isStarter()) {
                    ps.setInt(4, game.getPlayers()[0].getIDPlayer());
                    ps.setInt(5, game.getPlayers()[1].getIDPlayer());
                } else {
                    ps.setInt(4, game.getPlayers()[1].getIDPlayer());
                    ps.setInt(5, game.getPlayers()[0].getIDPlayer());
                }

                ps.executeUpdate();
                System.out.println("Game successfully inserted in the database !");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean insertScore(int IDPlayer, int IDOpponent) {
        if (scoreExist(IDPlayer, IDOpponent)) {
            System.out.println("A relation between these two players already exists.");
        } else {
            try {
                Connection c = getConnection();
                String sql = "INSERT INTO Score (IDPlayer, IDOpponent, NumberGames, NumberWins, NumberLosses) VALUES (?, ?, 0, 0, 0)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, IDPlayer);
                ps.setInt(2, IDOpponent);
                ps.executeUpdate();
                System.out.println("Score successfully inserted in the database !");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



    /* ~~~~~~~~~~~~~ Read ~~~~~~~~~~~~~ */
    public static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Player";

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPlayer = rs.getInt("IDPlayer");
                String username = rs.getString("Username");
                String passwordHash = rs.getString("Password");
                java.sql.Date profileCreationDate = rs.getDate("ProfileCreationDate");

                Player p = new Player(idPlayer, username, passwordHash, profileCreationDate);
                players.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }
    public static List<Game> getGames() {
        List<Game> games = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Game";

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idGame = rs.getInt("IDGame");
                Timestamp gameDate = rs.getTimestamp("GameDate");
                boolean finished = rs.getBoolean("Finished");
                int idWinner = rs.getInt("IDWinner");
                int idPlayerX = rs.getInt("IDPlayerX");
                int idPlayerO = rs.getInt("IDPlayerO");

                Game game = new Game(idGame, gameDate, finished, idWinner, idPlayerX, idPlayerO);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public static Player getPlayerByID(int IDPlayer) {
        try {
            String sql = "SELECT * FROM Player WHERE IDPlayer = ?";

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, IDPlayer);

            ResultSet rs = ps.executeQuery();
            rs.next();

            int idPlayer = rs.getInt("IDPlayer");
            String username = rs.getString("Username");
            String passwordHash = rs.getString("Password");
            java.sql.Date profileCreationDate = rs.getDate("ProfileCreationDate");

            return(new Player(idPlayer, username, passwordHash, profileCreationDate));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Game getGameByID(int IDGame) {
        try {
            String sql = "SELECT * FROM Game WHERE IDGame = ?";

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, IDGame);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idGame = rs.getInt("IDGame");
                Timestamp gameDate = rs.getTimestamp("GameDate");
                boolean finished = rs.getBoolean("Finished");
                int idWinner = rs.getInt("IDWinner");
                int idPlayerX = rs.getInt("IDPlayerX");
                int idPlayerO = rs.getInt("IDPlayerO");

                return new Game(idGame, gameDate, finished, idWinner, idPlayerX, idPlayerO);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Integer[][][][] getScoreByID(int IDPlayer, int IDOpponent) {
        try {
            String sql = "SELECT * FROM Score WHERE IDPlayer = ? AND IDOpponent = ?";

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, IDPlayer);
            ps.setInt(2, IDOpponent);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int numberGames = rs.getInt("NumberGames");
                int numberWins = rs.getInt("NumberWins");
                int numberLosses = rs.getInt("NumberLosses");
                int numberTies = numberGames - numberWins - numberLosses;

                return new Integer[numberGames][numberWins][numberLosses][numberTies];
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    /* ~~~~~~~~~~~~ Update ~~~~~~~~~~~~ */
    public static void modifyPlayer(int IDPlayer, int indiceAttribut, Object nouvelleValeur) {
        if (!playerExist(IDPlayer)) {
            System.out.println("This player's ID does not exist.");
        } else {
            try {
                String sql = switch (indiceAttribut) {
                    case 1 -> sql = "UPDATE Player SET username = ? WHERE IDPlayer = ?";
                    case 2 -> sql = "UPDATE Player SET passwordHash = ? WHERE IDPlayer = ?";
                    case 3 -> sql = "UPDATE Player SET profileCreationDate = ? WHERE IDPlayer = ?";
                    default -> throw new IllegalStateException("""
                            Modification not possible !
                            Choice for the index :
                            1 : Userame
                            2 : PasswordHash
                            3 : Profile Creation Date""");
                };

                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);

                ps.setObject(1, nouvelleValeur);
                ps.setInt(2, IDPlayer);
                ps.executeUpdate();

                System.out.println("The player with the ID " + IDPlayer + " has been successfully updated.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void modifyGame(int IDGame, int indiceAttribut, Object nouvelleValeur) {
        if (!gameExist(IDGame)) {
            System.out.println("This game's ID does not exist.");
        } else {
            try {
                String sql = switch (indiceAttribut) {
                    case 1 -> "UPDATE Game SET GameDate = ? WHERE IDGame = ?";
                    case 2 -> "UPDATE Game SET Finished = ? WHERE IDGame = ?";
                    case 3 -> "UPDATE Game SET IDWinner = ? WHERE IDGame = ?";
                    default -> throw new IllegalStateException("""
                            Modification not possible !
                            Choice for the index :
                            1 : Game Date
                            2 : Finished ?
                            3 : ID Winner""");
                };

                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);

                ps.setObject(1, nouvelleValeur);
                ps.setInt(2, IDGame);
                ps.executeUpdate();

                System.out.println("The game with the ID " + IDGame + " has been successfully updated.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void modifyScore(int IDPlayer, int IDOpponent, int indiceAttribut, Object nouvelleValeur) {
        if (!scoreExist(IDPlayer, IDOpponent)) {
            System.out.println("This score's IDs do not exist.");
        } else {
            try {
                String sql = switch (indiceAttribut) {
                    case 1 -> "UPDATE Score SET NumberGames = ? WHERE IDPlayer = ? AND IDOpponent = ?";
                    case 2 -> "UPDATE Score SET NumberWins = ? WHERE IDPlayer = ? AND IDOpponent = ?";
                    case 3 -> "UPDATE Score SET NumberLosses = ? WHERE IDPlayer = ? AND IDOpponent = ?";
                    default -> throw new IllegalStateException("""
                            Modification not possible !
                            Choice for the index :
                            1 : Number of games
                            2 : Number of wins
                            3 : Number of losses""");
                };

                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);

                ps.setObject(1, nouvelleValeur);
                ps.setInt(2, IDPlayer);
                ps.setInt(3, IDOpponent);
                ps.executeUpdate();

                System.out.println("The score for player ID " + IDPlayer + " and opponent ID " + IDOpponent + " has been successfully updated.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /* ~~~~~~~~~~~~ Delete ~~~~~~~~~~~~ */
    public static void deletePlayer(int IDPlayer) {
        if (!playerExist(IDPlayer)) {
            System.out.println("This player's ID does not exist.");
        } else {
            try {
                Connection c = getConnection();
                PreparedStatement ps;

                deleteGamesByPlayerID(IDPlayer);
                deleteScoresByPlayerID(IDPlayer);

                String sql = "DELETE FROM Player WHERE IDPlayer = ?";

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDPlayer);
                ps.executeUpdate();

                System.out.println("Player " + IDPlayer + " has been successfully deleted from the database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteGame(int IDGame) {
        if (!gameExist(IDGame)) {
            System.out.println("This game's ID does not exist.");
        } else {
            try {
                Connection c = getConnection();
                PreparedStatement ps;

                String sql = "DELETE FROM Game WHERE IDGame = ?";

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDGame);
                ps.executeUpdate();

                System.out.println("Game " + IDGame + " has been successfully deleted from the database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteScore(int IDPlayer, int IDOpponent) {
        if (!scoreExist(IDPlayer, IDOpponent)) {
            System.out.println("These two players have no score against each other in the database.");
        } else {
            try {
                Connection c = getConnection();
                PreparedStatement ps;

                String sql = "DELETE FROM Score WHERE IDPlayer = ? AND IDOpponent = ?";

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDPlayer);
                ps.setInt(2, IDOpponent);
                ps.executeUpdate();

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDOpponent);
                ps.setInt(2, IDPlayer);
                ps.executeUpdate();

                System.out.println("Score between Player" + IDPlayer + " and Player " + IDOpponent + " has been successfully deleted from the database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteScoresByPlayerID(int IDPlayer) {
        if (!playerExist(IDPlayer)) {
            System.out.println("This player's ID does not exist.");
        } else {
            try {
                Connection c = getConnection();
                PreparedStatement ps;

                String sql = "DELETE FROM Score WHERE IDPlayer = ? OR IDOpponent = ?";

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDPlayer);
                ps.setInt(2, IDPlayer);
                ps.executeUpdate();

                System.out.println("Scores related to the player " + IDPlayer + " have been successfully deleted from the database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteGamesByPlayerID(int IDPlayer) {
        if (!playerExist(IDPlayer)) {
            System.out.println("This player's ID does not exist.");
        } else {
            try {
                Connection c = getConnection();
                PreparedStatement ps;

                String sql = "DELETE FROM Game WHERE IDPlayerX = ? OR IDPlayerO = ?";

                ps = c.prepareStatement(sql);
                ps.setInt(1, IDPlayer);
                ps.setInt(2, IDPlayer);
                ps.executeUpdate();

                System.out.println("Games related to the player " + IDPlayer + " have been successfully deleted from the database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /* ================ Autres méthodes ================= */
    public static boolean verifyPassword(String username, String password) {
        if (!playerExist(username)) {
            System.out.println("This player's username does not exist.");
        } else {
            try {
                String sql = "SELECT password FROM Player WHERE username = ?";

                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                rs.next();
                String password_database = rs.getString("password");

                return (password.equals(password_database));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
