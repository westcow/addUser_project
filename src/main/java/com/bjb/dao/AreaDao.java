package com.bjb.dao;

import com.bjb.entity.Area;

import java.util.List;

public interface AreaDao {

    public List<Area> getAreaListBySuperiorCode(Integer superiorCode);

    public Area getAreaByAreaCode(Integer areaCode);
}
