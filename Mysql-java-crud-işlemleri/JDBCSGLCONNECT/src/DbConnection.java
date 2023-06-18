
import java.sql.*;

public class DbConnection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC sürücüsünü yükleyin
            Class.forName("com.mysql.jdbc.Driver");

            // Veritabanına bağlanmak için gerekli bilgileri ayarlayın
            String url = "jdbc:mysql://localhost:3306/Students";
            String username = "root";
            String password = "";

            // Bağlantıyı açın
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

            // Bağlantı başarılı olduysa burada işlemlerinizi gerçekleştirin
            System.out.println("Veritabanına bağlantı başarılı!");
            //Statement statement = connection.createStatement();

            PreparedStatement pr=connection.prepareStatement("INSERT INTO student (ad,soyad,yaş) VALUES (?,?,?)");
            pr.setString(1, "suna");
            pr.setString(2, "suna");
            pr.setInt(3, 24);
            pr.executeUpdate();

            
            


            pr.setString(1, "baran");
            pr.setString(2, "baran");
            pr.setInt(3, 24);
            pr.executeUpdate();
            
            /*
             * ResultSet resultSet = statement.executeQuery("select * from student");
             * while (resultSet.next()) {
             * System.out.println(resultSet.getInt("Student_id") + " " +
             * resultSet.getString(2));
             * }
             */
            //String ekle="INSERT INTO student (ad,soyad,yaş) VALUES (?,?,?)";
            // burda statment yönetimi için farklı bir yol
              /*PreparedStatement prst=connection.prepareStatement(ekle);
 
            prst.setString(1, "Ali");
            prst.setString(2, "veli");
            prst.setInt(3, 25);*/



            // ekle
            // System.out.println(statement.executeUpdate("INSERT INTO student
            // (ad,soyad,yaş) VALUES ('ahmet','veli',21) "));
            // güncelleme
            // statement.executeUpdate("UPDATE student SET ad='Mustafa' WHERE
            // student_id=2");
            // silme
            // statement.executeUpdate("DELETE FROM student WHERE student_id = 2");

            // Bağlantıyı kapatın
            connection.commit();
            connection.close();
        } catch (Exception e) {
            if(connection != null){
                 try {
                    connection.rollback();
                } catch (SQLException e1) {
                   
                    e1.printStackTrace();
                }
            };
            System.out.println("JDBC sürücüsü bulunamadı!");
            e.printStackTrace();
        } finally {
            // Bağlantıyı kapatırken hata oluşursa burada ele alabilirsiniz
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}