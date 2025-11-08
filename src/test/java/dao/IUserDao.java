package dao;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 下午2:48
 **/
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
