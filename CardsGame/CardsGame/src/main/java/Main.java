import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //requetes CREATE TABLE
    //private static final String createGroundColorTable = "CREATE TYPE IF NOT EXISTS groundcolor AS ENUM ('BLANC','BLEU','NOIR','ROUGE','VERT');";
    private static final String createCreatureTable = "CREATE TABLE IF NOT EXISTS creature (id SERIAL PRIMARY KEY, name VARCHAR(50), damagepoints INT, lifepoints INT, cost INT); ";
    private static final String createGroundTable = "CREATE TABLE IF NOT EXISTS ground (id SERIAL PRIMARY KEY, color VARCHAR(50) , manapoints INT, cost INT); ";
    private static final String dropCreatureTable = "DROP TABLE IF EXISTS creature";
    private static final String dropGroundTable = "DROP TABLE IF EXISTS ground";

    //infos de connexion aux databases
    private static final Map<String, String> pgInfo = new HashMap<String, String>();
    static {
        pgInfo.put("URL", "jdbc:postgresql://localhost:5432/postgres");
        pgInfo.put("USER", "change");
        pgInfo.put("PASSWD", "change");
    }

    public static void main(String[] args) throws ClassNotFoundException {

        //chargement des drivers
        Class.forName("org.postgresql.Driver");
        //tentative d'établissement de la connection
        try (Connection conn = DriverManager.getConnection(pgInfo.get("URL")
                , pgInfo.get("USER"), pgInfo.get("PASSWD"))) {
            //SI OK :
            //------------------
            // création des tables
            //createTables(conn);
            //------------------
            // au cas où ... drop des tables
            //dropTables(conn);
            //------------------
            //==================
            // GROUND
            //==================
            //------------------
            // création d'une instance de GroundDAO pour effectuer les actions CRUD qui suivent
            //GroundDAO grDAO = new GroundDAO(conn);
            //------------------
            // insertion
            //Ground gr = new Ground(GroundColor.VERT,112);
            //grDAO.insert(gr);
            //------------------
            // lectures
            //for (Ground gr : grDAO.selectAll()) {
            //    gr.display();
            //}
            //------------------
            // mises à jour
            //Ground gr = new Ground(GroundColor.NOIR,116);
            // mises à jour de manapoints
            //System.out.println(grDAO.updateManapoints(116,gr));
            // mises à jour de color
            //System.out.println(grDAO.updateColor(GroundColor.ROUGE,gr));
            //------------------
            // suppression
            //Ground gr = new Ground(GroundColor.ROUGE,116);
            //System.out.println(grDAO.delete(gr));
            //------------------
            //==================
            // CREATURE
            //==================
            //------------------
            // création d'une instance de GroundDAO pour effectuer les actions CRUD qui suivent
            //CreatureDAO crDAO = new CreatureDAO(conn);
            //------------------
            // insertion
            //creature cr = new Creature(11,"troll",111,1111);
            //crDAO.insert(cr);
            //------------------
            // lectures
            //for (Creature cr : crDAO.selectAll()) {
            //    cr.display();
            //}
            //------------------
            // mises à jour
            //Creature cr = new Creature(11,"troll",111,1111);
            // mise à jour de name
            //System.out.println(crDAO.updateName("cyclope",cr));
            //------------------
            // suppression
            //Creature cr = new Creature(11,"cyclope",111,1111);
            //System.out.println(crDAO.delete(cr));
            //------------------
            // sinon exception
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection c) {
        //create d'un objet de type Statement sur la connection
        //une instance de Statement permet d’envoyer une requête
        try (Statement s = c.createStatement()) {
            s.execute(createGroundTable);
            s.execute(createCreatureTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTables(Connection c) {

        try (Statement s = c.createStatement()) {
            s.execute(dropGroundTable);
            s.execute(dropCreatureTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
