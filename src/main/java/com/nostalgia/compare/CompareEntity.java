package com.nostalgia.compare;

/**
 * @author liunian
 * @createTime 2019/8/23
 * @description
 */
public class CompareEntity implements Comparable<CompareEntity>{

    private Integer id;

    private Integer sort;

    public CompareEntity(Integer id, Integer sort) {
        this.id = id;
        this.sort = sort;
    }

    public CompareEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(CompareEntity o) {
        if(this.sort.equals(o.getSort())){
            return 0;

        }else if(this.sort < o.getSort()){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "CompareEntity{" +
                "id=" + id +
                ", sort=" + sort +
                '}';
    }
}
