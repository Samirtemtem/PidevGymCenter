package Service;

import Entities.Client;
import Utils.Datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceClient implements IService<Client> {

    private Connection conn = Datasource.getConn();

    @Override
    public void add(Client client) throws SQLException {
        String query = "INSERT INTO client (Name, Address, Email, Password, PhoneNumber) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPassword());
            stmt.setString(5, client.getPhoneNumber());
            stmt.executeUpdate();

            // Retrieve the generated key (client ID)
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to retrieve client ID after insert");
                }
            }
        }
    }

    @Override
    public void update(Client client) throws SQLException {
        String query = "UPDATE client SET Name = ?, Address = ?, Email = ?, Password = ?, PhoneNumber = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPassword());
            stmt.setString(5, client.getPhoneNumber());
            stmt.setInt(6, client.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Client client) throws SQLException {
        String query = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, client.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Client findById(int id) throws SQLException {
        String query = "SELECT * FROM client WHERE id_c = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return createClientFromResultSet(rs);
                }
            }
        }
        // If no client is found, return null or throw an exception
        return null;
    }

    @Override
    public List<Client> ReadAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Client client = createClientFromResultSet(rs);
                clients.add(client);
            }
        }
        return clients;
    }

    private Client createClientFromResultSet(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("id_c"),
                rs.getString("Name"),
                rs.getString("Address"),
                rs.getString("Email"),
                rs.getString("Password"),
                rs.getString("PhoneNumber")
        );
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
