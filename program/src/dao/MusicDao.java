package dao;

import entity.Music;
import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicDao {

    /*** 查询全部歌单 */
    public  List<Music> findMusic(){
        List<Music> musics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("select *from music");
            rs = ps.executeQuery();
            while(rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musics.add(music);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtils.getClose(connection, ps, rs);
        }return musics;
    }
    /** * 根据id查找音乐 * @param id * @return */
    public  Music findMusicById(int id){
        Music music = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("select * from music where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtils.getClose(connection, ps, rs);
        }return music;
    }
    /** * 根据关键字查询歌单 */
    public  List<Music> ifMusic(String str){
        List<Music> musics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("select*from music where title like '%"+str+"%'");
            rs = ps.executeQuery();
            while(rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musics.add(music);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally { DBUtils.getClose(connection, ps, rs);
        }
        return musics;
    }
      /*** 上传音乐 */
      public  int Insert(String title, String singer, String time, String url, int userid) {
      Connection conn = DBUtils.getConnection();
      PreparedStatement ps=null;
      //number 代表受影响的行数
      int number = 0;
      try {
          ps=conn.prepareStatement("insert into music(title,singer,time,url,userid) values(?,?,?,?,?)");
          ps.setString(1,title);
          ps.setString(2,singer);
          ps.setString(3,time);
          ps.setString(4,url);
          ps.setInt(5,userid);
          number=ps.executeUpdate();
          return number;
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          DBUtils.getClose(conn, ps, null);
      }
      return 0;
      }
      //* 删除歌曲：
    public int deleteMusicById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
    }
    public static void main(String[] args) {
        /*List<Music> musicList = findMusic();
        System.out.println(musicList);
        Music music = findMusicById(1);
        System.out.println(music);
        List<Music>  musicList = ifMusic("南方");
        System.out.println(musicList);
        int num = Insert("天涯","任贤齐","2020-07-29","/天涯",1);
        System.out.println(num);*/

    }
}
