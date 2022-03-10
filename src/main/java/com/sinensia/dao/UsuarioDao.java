package com.sinensia.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetById;
import com.sinensia.model.Usuario;
public class UsuarioDao extends BaseDao implements IAdd<Usuario> , IGetById<Usuario> {
 private Connection connection;
	@Override
    public int add(Usuario usuario) throws SQLException {

        int idUsuario = 0;
        PreparedStatement preparedStatement = null;
        ResultSet rsKey = null;
        try {
            connection = super.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO usuario(id, nombre, password) VALUE (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, usuario.getIdusuario());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getPassword());

            preparedStatement.executeUpdate();

            rsKey = preparedStatement.getGeneratedKeys();
            rsKey.next();
            idUsuario= rsKey.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (rsKey != null)
                rsKey.close();
            if (connection != null)
                connection.close();
        }
        return idUsuario;
    }

	@Override
	public Usuario getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
