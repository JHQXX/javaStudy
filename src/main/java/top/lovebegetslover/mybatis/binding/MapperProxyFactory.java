package top.lovebegetslover.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: Lee
 * @Description: 代理工厂
 * @DateTime: 2025/11/8 下午2:39
 **/
public class MapperProxyFactory<T>{

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
