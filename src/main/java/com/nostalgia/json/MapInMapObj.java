package com.nostalgia.json;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/8/7
 * @description
 */
public class MapInMapObj {

    private String id;
    private String name;

    private Map<String,String> map;

    private Geo geo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    /*public MapObj getMapObj() {
        return mapObj;
    }

    public void setMapObj(MapObj mapObj) {
        this.mapObj = mapObj;
    }*/

    @Override
    public String toString() {
        return "MapInMapObj{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", map=" + map +
                ", geo=" + geo +
                '}';
    }
}
