import java.sql.*;
import java.util.List;

public class CreatureDAO {

    Connection c;

    public CreatureDAO(Connection c) {
        this.c = c;
    }

    public void insert(Creature cr) {
        try (PreparedStatement ps =
                     c.prepareStatement("INSERT INTO creature (id, name, damagepoints, lifepoints, cost)"
                                     + " VALUES(DEFAULT, ?, ?, ?, ?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            //le premier indice est "name", pas "id"
            ps.setString(1, cr.getName());
            ps.setInt(2, cr.getDamagesPoints());
            ps.setInt(3, cr.getLifePoints());
            ps.setInt(4, cr.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectLutin() {
        try (Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT name, damagepoints, lifepoints, cost FROM creature WHERE name='lutin'")) {
            System.out.println("SELECT name=LUTIN");
            System.out.println("-----------------");
            while (rs.next()) {
                System.out.println(" Points de damage : " + rs.getInt(2) + " Points de vie : " + rs.getInt(3) + " Coût : " + rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


