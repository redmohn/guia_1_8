package Database;

import cl.polett.taller.modelo.Guitarra;
import cl.polett.taller.modelo.Instrumento;
import cl.polett.taller.modelo.Piano;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polett
 */
public class BD {

    private Connection conectar() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/guia_1_8_Taller";
            String user = "root";
            String pass = "polett";
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            conexion = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return conexion;
    }

    private void desconectar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
    }

    public boolean agregarGuitarra(Guitarra guitarra) {
        boolean ok = false;
        try {
            if (guitarra != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO guia_1_8_Taller.instrumento(codigo, nombre, stock, tipo) VALUES (?,?,?,?)");
                    ps1.setString(1, guitarra.getCodigo());
                    ps1.setString(2, guitarra.getNombre());
                    ps1.setInt(3, guitarra.getStock());
                    ps1.setString(4, guitarra.getTipo());
                    ps1.execute();
                    PreparedStatement ps2 = conexion.prepareStatement("INSERT INTO guia_1_8_Taller.guitarra(clase) VALUES (?)");
                    ps2.setString(1, guitarra.getClase());
                    ps2.execute();
                    ok = true;
                }
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return ok;
    }

    public boolean agregarPiano(Piano piano) {
        boolean ok = false;
        try {
            if (piano != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO guia_1_8_taller.instrumento(codigo, nombre, stock, tipo) VALUES (?,?,?,?)");
                    ps1.setString(1, piano.getCodigo());
                    ps1.setString(2, piano.getNombre());
                    ps1.setInt(3, piano.getStock());
                    ps1.setString(4, piano.getTipo());
                    ps1.execute();
                    PreparedStatement ps2 = conexion.prepareStatement("INSERT INTO guia_1_8_taller.piano(cola) VALUES (?)");
                    ps2.setBoolean(1, ok);
                    ps2.execute();
                    ok = true;
                }
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return ok;
    }

    public boolean eliminar(Instrumento instrumento) {
        boolean ok = false;
        try {
            if (instrumento != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps = conexion.prepareStatement("DELETE FROM instrumento  WHERE codigo=?");
                    ps.setString(1, instrumento.getCodigo());
                    ps.execute();
                    ok = true;
                    desconectar(conexion);
                }
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return ok;
    }

    public Instrumento conocerInstrumento(String codigo) {
        Instrumento instrumento = null;
        try {
            if (codigo != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM libros WHERE codigo=?");
                    preparedStatement.setString(1, codigo);
                    //Similar al 'existe' pero esta vez guardaremos los valores de los parámetros en un nuevo objeto
                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            instrumento = new Instrumento();
                            instrumento.setCodigo(rs.getString("codigo"));
                            instrumento.setNombre(rs.getString("nombre"));
                            instrumento.setStock(rs.getInt("stock"));
                            instrumento.setTipo(rs.getString("tipo"));
                        }
                        rs.close();
                    }
                    desconectar(conexion);
                }
            }
        } catch (Exception e) {
            instrumento = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return instrumento;
    }

    public Guitarra encontrarGuitarra(String codigo) {
        Guitarra guitarra = null;
        try {
            if (codigo != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps = conexion.prepareStatement("SELECT*FROM guitarra WHERE codigo =?");
                    ps.setString(1, codigo);
                    ResultSet rs = ps.executeQuery();

                    if (rs != null) {
                        guitarra = new Guitarra();
                        guitarra.setCodigo(rs.getString("codigo"));
                        guitarra.setNombre(rs.getString("nombre"));
                        guitarra.setStock(rs.getInt("stock"));
                        guitarra.setTipo(rs.getString("tipo"));
                        guitarra.setClase(rs.getString("clase"));
                    }
                }
                desconectar(conexion);
            }
        } catch (Exception e) {
            guitarra = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return guitarra;
    }

    public Piano encontrarPiano(Integer codigo) {
        Piano piano = null;
        try {
            if (codigo != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps = conexion.prepareStatement("SELECT*FROM piano WHERE codigo =?");
                    ps.setInt(1, codigo);
                    ResultSet rs = ps.executeQuery();

                    if (rs != null) {
                        piano = new Piano();
                        piano.setCodigo(rs.getString("codigo"));
                        piano.setNombre(rs.getString("nombre"));
                        piano.setStock(rs.getInt("stock"));
                        piano.setTipo(rs.getString("tipo"));
                        piano.setDeCola(rs.getBoolean("cola"));
                    }
                }
                desconectar(conexion);
            }
        } catch (Exception e) {
            piano = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return piano;
    }

}
