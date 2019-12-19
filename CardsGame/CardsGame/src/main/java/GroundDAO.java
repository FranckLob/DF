import javax.xml.bind.annotation.XmlType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroundDAO {
    Connection c;

    public GroundDAO(Connection c) {
        this.c = c;
    }

    //INSERT
    public void insert(Ground gr) {
        try (PreparedStatement ps =
                     c.prepareStatement("INSERT INTO ground (id, color, manapoints, cost)"
                                     + " VALUES(DEFAULT, ?, ?, ?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            //le premier indice est "name", pas "id"
            //on remplace chaque ? par une valeur puis on exécute
            ps.setString(1, mapGroundColorToString(gr));
            ps.setInt(2, gr.getManaPoints());
            ps.setInt(3, gr.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //SELECT ALL : on retourne une liste d'objets Ground
    public List<Ground> selectAll() {
        try (Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT color, manapoints, cost FROM ground")) {
            List<Ground> list=new ArrayList<Ground>();
            while (rs.next()) {
                Ground ground = new Ground(mapStringToGroundColor(rs.getString(1)),rs.getInt(2));
                list.add(ground);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //UPDATE MANAPOINTS : paramètres = la nouvelle valeur de manapoints, l'instance de Ground à modifier; on retourne le nombre d'occurences impactées
    public int updateManapoints(int manaPoints, Ground gr) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE ground SET manapoints=? WHERE color=? AND manapoints=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            ps.setInt(1,manaPoints);
            ps.setString(2,mapGroundColorToString(gr));
            ps.setInt(3,gr.getManaPoints());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //UPDATE COLOR : paramètres = la nouvelle valeur de color, l'instance de Ground à modifier; on retourne le nombre d'occurences impactées
    public int updateColor(GroundColor grColor, Ground gr) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE ground SET color=? WHERE color=? AND manapoints=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            //2 utilisations de mapGroundColorToString, méthode surchargée
            ps.setString(1,mapGroundColorToString(grColor));
            ps.setString(2,mapGroundColorToString(gr));
            ps.setInt(3,gr.getManaPoints());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //DELETE; on retourne le nombre d'occurences impactées
    public int delete(Ground gr) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM ground WHERE  color=? AND manapoints=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            ps.setString(1,mapGroundColorToString(gr));
            ps.setInt(2,gr.getManaPoints());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    //dans la fonction ci-dessous on agit sur la table mais pas via un objet de classe Ground
    public int deleteId(int id) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM ground WHERE id=?")) {
            //on remplace chaque ? par une valeur puis on exécute
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //on récupère une String de couleur à partir d'un objet GroundColor
    public String mapGroundColorToString(GroundColor grColor) {
        return grColor.name();
    }

    //on récupère une String de couleur à partir d'un objet Ground
    public String mapGroundColorToString(Ground gr) {
        return gr.getColor().name();

        /* String color;
        switch (gr.getColor()) {
            case BLANC:
                color = "BLANC";
                break;
            case BLEU:
                color = "BLEU";
                break;
            case NOIR:
                color = "NOIR";
                break;
            case VERT:
                color = "VERT";
                break;
            case ROUGE:
                color = "ROUGE";
                break;
            default:
                color = "";
        }
        return color;*/
    }

    //on récupère un GroundColor à partir d'une String de couleur
    public GroundColor mapStringToGroundColor(String color) {
        try {
            return GroundColor.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exception){
            return GroundColor.BLANC;
        }

        /*GroundColor groundColor;
        switch (color) {
            case "BLANC":
                groundColor = GroundColor.BLANC;
                break;
            case "BLEU":
                groundColor = GroundColor.BLEU;
                break;
            case "NOIR":
                groundColor = GroundColor.NOIR;
                break;
            case "VERT":
                groundColor = GroundColor.VERT;
                break;
            case "ROUGE":
                groundColor = GroundColor.ROUGE;
                break;
            default:
                groundColor = GroundColor.BLANC;
        }
        return groundColor;*/
    }

}