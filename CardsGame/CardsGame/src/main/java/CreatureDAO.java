import java.sql.*;
import java.util.ArrayList;
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

    //SELECT ALL : on retourne une liste d'objets Creature
    public List<Creature> selectAll() {
        try (Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT name, damagepoints, lifepoints, cost FROM creature")) {
            List<Creature> list=new ArrayList<Creature>();
            while (rs.next()) {
                Creature creature = new Creature(rs.getInt(4),rs.getString(1),rs.getInt(2),rs.getInt(3));
                list.add(creature);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //UPDATE NAME : paramètres = la nouvelle valeur de name, l'instance de Creature à modifier; on retourne le nombre d'occurences impactées
    public int updateName(String name, Creature cr) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE creature SET name =? WHERE name=? AND damagepoints=? and lifepoints=? and cost=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            ps.setString(1,name);
            ps.setString(2,cr.getName());
            ps.setInt(3,cr.getDamagesPoints());
            ps.setInt(4,cr.getLifePoints());
            ps.setInt(5,cr.getCost());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //DELETE; on retourne le nombre d'occurences impactées
    public int delete(Creature cr) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM creature WHERE name=? AND damagepoints=? AND lifepoints=? AND cost=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            ps.setString(1,cr.getName());
            ps.setInt(2,cr.getDamagesPoints());
            ps.setInt(3,cr.getLifePoints());
            ps.setInt(4,cr.getCost());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}


